package dov.com.qq.im.ae.play;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AEPlayShowGridAdapter
  extends RecyclerView.Adapter<AEPlayShowGridViewHolder>
  implements AEPlayShowGridViewHolder.ItemClickCallback
{
  private static final String TAG = "AEPlayShowGridAdapter";
  public static AEMaterialMetaData selectedMaterial;
  public static AEMaterialMetaData selectedMidMaterial;
  private String curTabId = "";
  private AECaptureController mAECaptureController;
  private Map<String, AEPlayShowGridViewHolder> mCachedViewHolder;
  private AEVideoStoryCaptureModeViewModel mCaptureModeViewModel;
  private Context mContext;
  private int mLayoutType;
  private List<AEMaterialMetaData> mMaterialList;
  private AEMaterialManager mMidMaterialManager;
  private VideoStoryCapturePartManager mPartManager;
  private AEPlayShowGridAdapter.SizeInfo mSizeInfo;
  private AEPituCameraUnit mUnit;
  
  public AEPlayShowGridAdapter(@NonNull Context paramContext, @NonNull VideoStoryCapturePartManager paramVideoStoryCapturePartManager, @NonNull AEPlayShowGridAdapter.SizeInfo paramSizeInfo, int paramInt)
  {
    this.mContext = paramContext;
    this.mPartManager = paramVideoStoryCapturePartManager;
    this.mUnit = ((AEPituCameraUnit)this.mPartManager.a(65537, new Object[0]));
    this.mAECaptureController = this.mUnit.a();
    this.mSizeInfo = paramSizeInfo;
    this.mLayoutType = paramInt;
    this.mMidMaterialManager = ((AEMaterialManager)QIMManager.a().c(18));
    this.mCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.mUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.mCachedViewHolder = new HashMap();
  }
  
  private void addProgressObserver(String paramString, IProgressObserver paramIProgressObserver)
  {
    try
    {
      Iterator localIterator = PlayDownloadManagerWrap.getInstance().getDownloadingMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          PlayDownloadManagerWrap.getInstance().addProgressObserver(paramString, paramIProgressObserver);
        }
      }
      return;
    }
    finally {}
  }
  
  private void applyTemplate(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.g == 0)
    {
      selectedMidMaterial = paramAEMaterialMetaData;
      new StringBuilder().append(QIMPtvTemplateManager.a).append(paramAEMaterialMetaData.jdField_f_of_type_JavaLangString).toString();
      this.mAECaptureController.a(paramAEMaterialMetaData);
      i = AEBeautyProviderView.a();
      this.mAECaptureController.a(i);
      i = AEBeautyProviderView.b();
      this.mAECaptureController.b(i);
      this.mPartManager.a(393218, new Object[] { paramAEMaterialMetaData });
    }
    while ((paramAEMaterialMetaData.g != 4) && (paramAEMaterialMetaData.g != 5) && (paramAEMaterialMetaData.g != 6) && (paramAEMaterialMetaData.g != 7))
    {
      int i;
      return;
    }
    selectedMidMaterial = null;
    this.mPartManager.a(655361, new Object[] { paramAEMaterialMetaData });
  }
  
  private void downloadTemplate(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData.jdField_f_of_type_Boolean) || (TextUtils.isEmpty(paramAEMaterialMetaData.a))) {
      return;
    }
    downloadTemplateDirectly(paramAEMaterialMetaData);
  }
  
  private void downloadTemplateDirectly(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEPlayShowGridViewHolder localAEPlayShowGridViewHolder = (AEPlayShowGridViewHolder)this.mCachedViewHolder.get(paramAEMaterialMetaData.a);
    if (localAEPlayShowGridViewHolder != null) {
      localAEPlayShowGridViewHolder.onDownloadStart();
    }
    AEQLog.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + paramAEMaterialMetaData.a);
    PlayDownloadManagerWrap.getInstance().addProgressObserver(paramAEMaterialMetaData.a, localAEPlayShowGridViewHolder);
    PlayDownloadManagerWrap.getInstance().startDownload(this.mPartManager, this.mMidMaterialManager, paramAEMaterialMetaData);
  }
  
  public static void onSelectedMidMaterialConsumed()
  {
    selectedMidMaterial = null;
  }
  
  private void removeProgressObserver(String paramString, AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    try
    {
      Iterator localIterator = PlayDownloadManagerWrap.getInstance().getDownloadingMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          PlayDownloadManagerWrap.getInstance().removeProgressObserver(paramString, paramAEPlayShowGridViewHolder);
        }
      }
      return;
    }
    finally {}
  }
  
  private void scanExistHolderToObserve(String paramString)
  {
    if (this.mCachedViewHolder == null) {}
    do
    {
      do
      {
        return;
      } while (this.mCachedViewHolder.get(paramString) == null);
      paramString = (AEPlayShowGridViewHolder)this.mCachedViewHolder.get(paramString);
    } while ((paramString == null) || (paramString.mPlayMaterial == null) || (!paramString.mPlayMaterial.jdField_f_of_type_Boolean));
    addProgressObserver(paramString.mPlayMaterial.a, paramString);
  }
  
  public static boolean selectedMidMaterialNotConsumed()
  {
    return selectedMidMaterial != null;
  }
  
  private void toMiniApp(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.mPartManager.a(655363, new Object[] { paramAEMaterialMetaData });
  }
  
  private void toWebView(@NonNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.mPartManager.a(655362, new Object[] { paramAEMaterialMetaData });
  }
  
  public int getItemCount()
  {
    return this.mMaterialList.size();
  }
  
  public void initObservers()
  {
    if ((this.mCachedViewHolder == null) || (this.mCachedViewHolder.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mCachedViewHolder.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          localObject = (String)((Map.Entry)localObject).getKey();
          if (localObject != null) {
            scanExistHolderToObserve((String)localObject);
          }
        }
      }
    }
  }
  
  public void onBindViewHolder(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.mMaterialList.get(paramInt);
    paramAEPlayShowGridViewHolder.bind(localAEMaterialMetaData, paramInt);
    if ((this.curTabId != null) && (this.curTabId.equals(localAEMaterialMetaData.n)))
    {
      AEBaseReportParam.a().d(paramAEPlayShowGridViewHolder.mPlayMaterial.g);
      AEBaseReportParam.a().c(paramInt + 1);
      AEBaseDataReporter.a().g(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAEPlayShowGridViewHolder, paramInt, getItemId(paramInt));
  }
  
  public AEPlayShowGridViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mLayoutType == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558531, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558532, paramViewGroup, false)) {
      return new AEPlayShowGridViewHolder(paramViewGroup, this.mSizeInfo, this, this.mLayoutType);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mCachedViewHolder.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      PlayDownloadManagerWrap.getInstance().removeProgressObserver((String)localEntry.getKey(), (IProgressObserver)localEntry.getValue());
    }
  }
  
  public void onItemClicked(View paramView, @NonNull AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (AEFastClickThrottle.a(paramView)) {}
    label140:
    label187:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        AEBaseReportParam.a().c(paramInt);
        AEBaseReportParam.a().i("3");
        AEBaseReportParam.a().d(paramAEMaterialMetaData.g);
        selectedMaterial = paramAEMaterialMetaData;
        AEQLog.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + paramAEMaterialMetaData.g);
        AEQLog.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + paramAEMaterialMetaData.a);
        if (!AEMaterialMetaData.b(paramAEMaterialMetaData)) {
          break label187;
        }
        if (!paramAEMaterialMetaData.e) {
          break label140;
        }
        applyTemplate(paramAEMaterialMetaData);
      }
      for (;;)
      {
        AEBaseDataReporter.a().d(paramAEMaterialMetaData.a);
        return;
        paramInt += 1;
        break;
        if (!NetworkUtil.a())
        {
          selectedMaterial = null;
          selectedMidMaterial = null;
          QQToast.a(this.mContext, this.mContext.getString(2131718193), 0).a();
        }
        else
        {
          downloadTemplate(paramAEMaterialMetaData);
        }
      }
      if (paramAEMaterialMetaData.g == 2)
      {
        toWebView(paramAEMaterialMetaData);
        AEBaseDataReporter.a().d(paramAEMaterialMetaData.a);
        return;
      }
    } while (paramAEMaterialMetaData.g != 3);
    toMiniApp(paramAEMaterialMetaData);
    AEBaseDataReporter.a().d(paramAEMaterialMetaData.a);
  }
  
  public void onViewAttachedToWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewAttachedToWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.a)) && (AEMaterialMetaData.b(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.put(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
      paramAEPlayShowGridViewHolder.resetProgress();
      addProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewDetachedFromWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.a)) && (AEMaterialMetaData.b(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.remove(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
      paramAEPlayShowGridViewHolder.resetProgress();
      removeProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
      scanExistHolderToObserve(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
    }
  }
  
  public void putData(@NonNull List<AEMaterialMetaData> paramList)
  {
    this.mMaterialList = paramList;
    if (this.mMaterialList.size() == 0) {
      this.mCachedViewHolder.clear();
    }
    notifyDataSetChanged();
  }
  
  public void setCurTabId(String paramString)
  {
    this.curTabId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridAdapter
 * JD-Core Version:    0.7.0.1
 */