package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AEWaterMarkAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, Observer, AEMaterialDownloader.MaterialDownloadListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AEWaterMarkPanel.AEWaterMarkPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEMaterialManager jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  private AEMaterialMetaData jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = null;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList<AEMaterialMetaData> a;
  
  AEWaterMarkAdapter(Context paramContext, AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = paramAEWaterMarkPanelListener;
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a(18));
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 114);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 115);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 1025);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 113);
  }
  
  private int a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramAEMaterialMetaData.jdField_a_of_type_JavaLangString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) && (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.equals(paramAEMaterialMetaData)))
    {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b = false;
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c = false;
    }
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((paramObject.getId() != null) && (paramObject.getId().equals(((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          ((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean = paramBoolean;
          notifyItemChanged(i, Integer.valueOf(1));
          return;
        }
        i += 1;
      }
    }
  }
  
  private static void b(RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {}
    LinearLayoutManager localLinearLayoutManager;
    do
    {
      return;
      localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    } while (localLinearLayoutManager == null);
    paramRecyclerView = new AEWaterMarkAdapter.7(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {}
    while ((paramAEMaterialMetaData.f) || (TextUtils.isEmpty(paramAEMaterialMetaData.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager == null)) {
      return;
    }
    c(paramAEMaterialMetaData);
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      AEQLog.d("AEWaterMarkAdapter", "mTemplateList is null");
      notifyDataSetChanged();
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData1 = AEMaterialManager.b();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      AEMaterialMetaData localAEMaterialMetaData2 = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localAEMaterialMetaData1 != null)
      {
        k = j;
        if (localAEMaterialMetaData1.jdField_a_of_type_JavaLangString.equals(localAEMaterialMetaData2.jdField_a_of_type_JavaLangString)) {
          k = i;
        }
      }
      i += 1;
    }
    a(j);
  }
  
  public void a(int paramInt)
  {
    AEQLog.a("AEWaterMarkAdapter", "setSelectedIndex:" + paramInt);
    notifyDataSetChanged();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEWaterMarkAdapter.3(this, paramInt));
    }
  }
  
  public void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    AEQLog.a("AEWaterMarkAdapter", "setCircleCaptureStyle:" + paramRatio);
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new AEWaterMarkAdapter.2(this), 200L);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.8(this, paramInt, paramVarArgs));
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData1 = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localAEMaterialMetaData1 == null) {}
    AEMaterialMetaData localAEMaterialMetaData2;
    label134:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        localAEMaterialMetaData2 = AEMaterialManager.b();
        if (!(paramViewHolder instanceof AEMaterialWaterMarkNoneViewHolder)) {
          break;
        }
        if (localAEMaterialMetaData2 == null)
        {
          ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
            break label134;
          }
          ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837668));
          break;
          ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_b_of_type_AndroidViewView.setVisibility(0);
        ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167381));
      }
    } while (!(paramViewHolder instanceof AEMaterialWaterMarkViewHolder));
    AEMaterialWaterMarkViewHolder localAEMaterialWaterMarkViewHolder = (AEMaterialWaterMarkViewHolder)paramViewHolder;
    localAEMaterialWaterMarkViewHolder.a(localAEMaterialMetaData1);
    boolean bool;
    if (localAEMaterialMetaData2 == null)
    {
      if (paramInt != 0) {
        break label367;
      }
      bool = true;
    }
    for (;;)
    {
      label202:
      if (bool)
      {
        if (localAEMaterialMetaData2 != null) {
          localAEMaterialMetaData1.jdField_a_of_type_Boolean = localAEMaterialMetaData2.jdField_a_of_type_Boolean;
        }
        if (localAEMaterialMetaData1.jdField_a_of_type_Boolean)
        {
          localAEMaterialWaterMarkViewHolder.e.setVisibility(8);
          localAEMaterialWaterMarkViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label248:
          localAEMaterialWaterMarkViewHolder.a(8);
          localAEMaterialWaterMarkViewHolder.b(8);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
          break label365;
        }
        ((AEMaterialWaterMarkViewHolder)paramViewHolder).jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837668));
        break;
        bool = localAEMaterialMetaData2.jdField_a_of_type_JavaLangString.equals(localAEMaterialMetaData1.jdField_a_of_type_JavaLangString);
        break label202;
        localAEMaterialWaterMarkViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localAEMaterialWaterMarkViewHolder.e.setVisibility(0);
        break label248;
        localAEMaterialWaterMarkViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localAEMaterialWaterMarkViewHolder.e.setVisibility(8);
        localAEMaterialWaterMarkViewHolder.b(localAEMaterialMetaData1);
      }
      label365:
      break;
      label367:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition(paramView);
    if (i == -1) {}
    label206:
    label342:
    label349:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener == null)
      {
        AEQLog.d("AEWaterMarkAdapter", "water mark mlistener is null");
      }
      else
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((i == 0) || (localAEMaterialMetaData == null))
        {
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener.a();
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.b(null, true);
          a(0);
          AEBaseDataReporter.a().at();
        }
        for (;;)
        {
          if (!AECameraEntry.k(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent())) {
            break label349;
          }
          Object localObject = new HashMap();
          ((HashMap)localObject).put("ext2", localAEMaterialMetaData.jdField_a_of_type_JavaLangString);
          AEReportUtils.b(9, (HashMap)localObject);
          break;
          if ((!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) && (!localAEMaterialMetaData.e))
          {
            AEQLog.d("AEWaterMarkAdapter", "net work not available");
            ToastUtil.a().a(HardCodeUtil.a(2131716227));
            break;
          }
          a(localAEMaterialMetaData);
          AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
          if (localAEMaterialMetaData.jdField_a_of_type_JavaLangString == null)
          {
            localObject = "none";
            localAEBaseDataReporter.o((String)localObject);
            if (!localAEMaterialMetaData.b) {
              break label304;
            }
            localAEMaterialMetaData.c = true;
          }
          for (;;)
          {
            this.jdField_a_of_type_JavaLangString = localAEMaterialMetaData.jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_JavaLangString);
            if (!localAEMaterialMetaData.e) {
              break label342;
            }
            if (AEResUtil.a()) {
              break label313;
            }
            QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709793), 0).a();
            ThreadManager.excute(new AEWaterMarkAdapter.1(this), 64, null, true);
            break;
            localObject = localAEMaterialMetaData.jdField_a_of_type_JavaLangString;
            break label206;
            localAEMaterialMetaData.b = true;
          }
          this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.b(localAEMaterialMetaData, true);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener.a(localAEMaterialMetaData);
          a(i);
          continue;
          b(localAEMaterialMetaData);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0) {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558499, paramViewGroup, false);
    }
    for (paramViewGroup = new AEMaterialWaterMarkNoneViewHolder(localView);; paramViewGroup = new AEMaterialWaterMarkViewHolder(localView, this.jdField_a_of_type_AndroidContentContext))
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558498, paramViewGroup, false);
    }
  }
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {}
    do
    {
      do
      {
        return;
        paramInt = a(paramAEMaterialMetaData);
      } while (paramInt <= 0);
      ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.4(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.5(this));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = a(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.6(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter
 * JD-Core Version:    0.7.0.1
 */