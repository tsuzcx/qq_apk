package dov.com.qq.im.ae.play;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bmxa;
import bmxz;
import bnbg;
import bnkb;
import bnke;
import bnpz;
import bnqc;
import bnqm;
import bnqq;
import bnrf;
import bnrh;
import bogd;
import bpqs;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
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
  public static bnke selectedMaterial;
  public static bnke selectedMidMaterial;
  private String curTabId = "";
  private bnbg mAECaptureController;
  private Map<String, AEPlayShowGridViewHolder> mCachedViewHolder;
  private bnpz mCaptureModeViewModel;
  private Context mContext;
  private int mLayoutType;
  private List<bnke> mMaterialList;
  private bnkb mMidMaterialManager;
  private bnqc mPartManager;
  private AEPlayShowGridAdapter.SizeInfo mSizeInfo;
  private bmxa mUnit;
  
  public AEPlayShowGridAdapter(@NonNull Context paramContext, @NonNull bnqc parambnqc, @NonNull AEPlayShowGridAdapter.SizeInfo paramSizeInfo, int paramInt)
  {
    this.mContext = paramContext;
    this.mPartManager = parambnqc;
    this.mUnit = ((bmxa)this.mPartManager.a(65537, new Object[0]));
    this.mAECaptureController = this.mUnit.a();
    this.mSizeInfo = paramSizeInfo;
    this.mLayoutType = paramInt;
    this.mMidMaterialManager = ((bnkb)bogd.a().c(18));
    this.mCaptureModeViewModel = ((bnpz)bmxz.a(this.mUnit).get(bnpz.class));
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
  
  private void applyTemplate(@NonNull bnke parambnke)
  {
    if (parambnke.g == 0)
    {
      selectedMidMaterial = parambnke;
      new StringBuilder().append(bpqs.a).append(parambnke.jdField_f_of_type_JavaLangString).toString();
      this.mAECaptureController.a(parambnke);
      i = AEBeautyProviderView.a();
      this.mAECaptureController.a(i);
      i = AEBeautyProviderView.b();
      this.mAECaptureController.b(i);
      this.mPartManager.a(393218, new Object[] { parambnke });
    }
    while ((parambnke.g != 4) && (parambnke.g != 5) && (parambnke.g != 6) && (parambnke.g != 7))
    {
      int i;
      return;
    }
    selectedMidMaterial = null;
    this.mPartManager.a(655361, new Object[] { parambnke });
  }
  
  private void downloadTemplate(@NonNull bnke parambnke)
  {
    if ((parambnke.jdField_f_of_type_Boolean) || (TextUtils.isEmpty(parambnke.a))) {
      return;
    }
    downloadTemplateDirectly(parambnke);
  }
  
  private void downloadTemplateDirectly(@NonNull bnke parambnke)
  {
    AEPlayShowGridViewHolder localAEPlayShowGridViewHolder = (AEPlayShowGridViewHolder)this.mCachedViewHolder.get(parambnke.a);
    if (localAEPlayShowGridViewHolder != null) {
      localAEPlayShowGridViewHolder.onDownloadStart();
    }
    bnrh.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + parambnke.a);
    PlayDownloadManagerWrap.getInstance().addProgressObserver(parambnke.a, localAEPlayShowGridViewHolder);
    PlayDownloadManagerWrap.getInstance().startDownload(this.mPartManager, this.mMidMaterialManager, parambnke);
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
  
  private void toMiniApp(@NonNull bnke parambnke)
  {
    this.mPartManager.a(655363, new Object[] { parambnke });
  }
  
  private void toWebView(@NonNull bnke parambnke)
  {
    this.mPartManager.a(655362, new Object[] { parambnke });
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
    bnke localbnke = (bnke)this.mMaterialList.get(paramInt);
    paramAEPlayShowGridViewHolder.bind(localbnke, paramInt);
    if ((this.curTabId != null) && (this.curTabId.equals(localbnke.k)))
    {
      bnqq.a().d(paramAEPlayShowGridViewHolder.mPlayMaterial.g);
      bnqq.a().c(paramInt + 1);
      bnqm.a().g(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAEPlayShowGridViewHolder, paramInt, getItemId(paramInt));
  }
  
  public AEPlayShowGridViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mLayoutType == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558520, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558521, paramViewGroup, false)) {
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
  
  public void onItemClicked(View paramView, @NonNull bnke parambnke, int paramInt)
  {
    if (bnrf.a(paramView)) {}
    label140:
    label187:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bnqq.a().c(paramInt);
        bnqq.a().f("3");
        bnqq.a().d(parambnke.g);
        selectedMaterial = parambnke;
        bnrh.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + parambnke.g);
        bnrh.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + parambnke.a);
        if (!bnke.b(parambnke)) {
          break label187;
        }
        if (!parambnke.e) {
          break label140;
        }
        applyTemplate(parambnke);
      }
      for (;;)
      {
        bnqm.a().d(parambnke.a);
        return;
        paramInt += 1;
        break;
        if (!NetworkUtil.isNetworkAvailable())
        {
          selectedMaterial = null;
          selectedMidMaterial = null;
          QQToast.a(this.mContext, this.mContext.getString(2131717691), 0).a();
        }
        else
        {
          downloadTemplate(parambnke);
        }
      }
      if (parambnke.g == 2)
      {
        toWebView(parambnke);
        bnqm.a().d(parambnke.a);
        return;
      }
    } while (parambnke.g != 3);
    toMiniApp(parambnke);
    bnqm.a().d(parambnke.a);
  }
  
  public void onViewAttachedToWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewAttachedToWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.a)) && (bnke.b(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.put(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
      paramAEPlayShowGridViewHolder.resetProgress();
      addProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewDetachedFromWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.a)) && (bnke.b(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.remove(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
      paramAEPlayShowGridViewHolder.resetProgress();
      removeProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
      scanExistHolderToObserve(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
    }
  }
  
  public void putData(@NonNull List<bnke> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridAdapter
 * JD-Core Version:    0.7.0.1
 */