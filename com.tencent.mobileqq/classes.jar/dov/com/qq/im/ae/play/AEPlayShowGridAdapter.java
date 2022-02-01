package dov.com.qq.im.ae.play;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bljy;
import blks;
import blnv;
import bluy;
import blvb;
import bmap;
import bmas;
import bmbc;
import bmbg;
import bmbv;
import bmbx;
import bmql;
import boba;
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
  public static blvb selectedMaterial;
  public static blvb selectedMidMaterial;
  private String curTabId = "";
  private blnv mAECaptureController;
  private Map<String, AEPlayShowGridViewHolder> mCachedViewHolder;
  private bmap mCaptureModeViewModel;
  private Context mContext;
  private int mLayoutType;
  private List<blvb> mMaterialList;
  private bluy mMidMaterialManager;
  private bmas mPartManager;
  private AEPlayShowGridAdapter.SizeInfo mSizeInfo;
  private bljy mUnit;
  
  public AEPlayShowGridAdapter(@NonNull Context paramContext, @NonNull bmas parambmas, @NonNull AEPlayShowGridAdapter.SizeInfo paramSizeInfo, int paramInt)
  {
    this.mContext = paramContext;
    this.mPartManager = parambmas;
    this.mUnit = ((bljy)this.mPartManager.a(65537, new Object[0]));
    this.mAECaptureController = this.mUnit.a();
    this.mSizeInfo = paramSizeInfo;
    this.mLayoutType = paramInt;
    this.mMidMaterialManager = ((bluy)bmql.a().c(18));
    this.mCaptureModeViewModel = ((bmap)blks.a(this.mUnit).get(bmap.class));
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
  
  private void applyTemplate(@NonNull blvb paramblvb)
  {
    if (paramblvb.g == 0)
    {
      selectedMidMaterial = paramblvb;
      new StringBuilder().append(boba.a).append(paramblvb.jdField_f_of_type_JavaLangString).toString();
      this.mAECaptureController.a(paramblvb);
      i = AEBeautyProviderView.a();
      this.mAECaptureController.a(i);
      i = AEBeautyProviderView.b();
      this.mAECaptureController.b(i);
      this.mPartManager.a(393218, new Object[] { paramblvb });
    }
    while ((paramblvb.g != 4) && (paramblvb.g != 5) && (paramblvb.g != 6) && (paramblvb.g != 7))
    {
      int i;
      return;
    }
    selectedMidMaterial = null;
    this.mPartManager.a(655361, new Object[] { paramblvb });
  }
  
  private void downloadTemplate(@NonNull blvb paramblvb)
  {
    if ((paramblvb.jdField_f_of_type_Boolean) || (TextUtils.isEmpty(paramblvb.a))) {
      return;
    }
    downloadTemplateDirectly(paramblvb);
  }
  
  private void downloadTemplateDirectly(@NonNull blvb paramblvb)
  {
    AEPlayShowGridViewHolder localAEPlayShowGridViewHolder = (AEPlayShowGridViewHolder)this.mCachedViewHolder.get(paramblvb.a);
    if (localAEPlayShowGridViewHolder != null) {
      localAEPlayShowGridViewHolder.onDownloadStart();
    }
    bmbx.b("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + paramblvb.a);
    PlayDownloadManagerWrap.getInstance().addProgressObserver(paramblvb.a, localAEPlayShowGridViewHolder);
    PlayDownloadManagerWrap.getInstance().startDownload(this.mPartManager, this.mMidMaterialManager, paramblvb);
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
  
  private void toMiniApp(@NonNull blvb paramblvb)
  {
    this.mPartManager.a(655363, new Object[] { paramblvb });
  }
  
  private void toWebView(@NonNull blvb paramblvb)
  {
    this.mPartManager.a(655362, new Object[] { paramblvb });
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
    blvb localblvb = (blvb)this.mMaterialList.get(paramInt);
    paramAEPlayShowGridViewHolder.bind(localblvb, paramInt);
    if ((this.curTabId != null) && (this.curTabId.equals(localblvb.k)))
    {
      bmbg.a().d(paramAEPlayShowGridViewHolder.mPlayMaterial.g);
      bmbg.a().c(paramInt + 1);
      bmbc.a().g(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAEPlayShowGridViewHolder, paramInt, getItemId(paramInt));
  }
  
  public AEPlayShowGridViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mLayoutType == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558509, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558510, paramViewGroup, false)) {
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
  
  public void onItemClicked(View paramView, @NonNull blvb paramblvb, int paramInt)
  {
    if (bmbv.a(paramView)) {}
    label140:
    label187:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bmbg.a().c(paramInt);
        bmbg.a().f("3");
        bmbg.a().d(paramblvb.g);
        selectedMaterial = paramblvb;
        bmbx.b("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + paramblvb.g);
        bmbx.b("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + paramblvb.a);
        if (!blvb.b(paramblvb)) {
          break label187;
        }
        if (!paramblvb.e) {
          break label140;
        }
        applyTemplate(paramblvb);
      }
      for (;;)
      {
        bmbc.a().d(paramblvb.a);
        return;
        paramInt += 1;
        break;
        if (!NetworkUtil.isNetworkAvailable())
        {
          selectedMaterial = null;
          selectedMidMaterial = null;
          QQToast.a(this.mContext, this.mContext.getString(2131717325), 0).a();
        }
        else
        {
          downloadTemplate(paramblvb);
        }
      }
      if (paramblvb.g == 2)
      {
        toWebView(paramblvb);
        bmbc.a().d(paramblvb.a);
        return;
      }
    } while (paramblvb.g != 3);
    toMiniApp(paramblvb);
    bmbc.a().d(paramblvb.a);
  }
  
  public void onViewAttachedToWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewAttachedToWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.a)) && (blvb.b(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.put(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
      paramAEPlayShowGridViewHolder.resetProgress();
      addProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder)
  {
    super.onViewDetachedFromWindow(paramAEPlayShowGridViewHolder);
    if ((paramAEPlayShowGridViewHolder.mPlayMaterial != null) && (!TextUtils.isEmpty(paramAEPlayShowGridViewHolder.mPlayMaterial.a)) && (blvb.b(paramAEPlayShowGridViewHolder.mPlayMaterial)))
    {
      this.mCachedViewHolder.remove(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
      paramAEPlayShowGridViewHolder.resetProgress();
      removeProgressObserver(paramAEPlayShowGridViewHolder.mPlayMaterial.a, paramAEPlayShowGridViewHolder);
      scanExistHolderToObserve(paramAEPlayShowGridViewHolder.mPlayMaterial.a);
    }
  }
  
  public void putData(@NonNull List<blvb> paramList)
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