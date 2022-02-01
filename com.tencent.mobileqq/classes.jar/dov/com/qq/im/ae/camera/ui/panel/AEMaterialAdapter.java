package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AEMaterialAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, Observer, AEMaterialDownloader.MaterialDownloadListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AEGridView jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialManager jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  public AEMaterialMetaData a;
  public String a;
  public ArrayList<AEMaterialMetaData> a;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AEMaterialAdapter(Context paramContext, AEGridView paramAEGridView, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a(18));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView = paramAEGridView;
    this.jdField_a_of_type_Boolean = paramBoolean;
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
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramAEMaterialMetaData == null) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    label423:
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramAEMaterialMetaData.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_JavaLangString);
      AEBaseReportParam.a().c(-1);
      AEBaseReportParam.a().j("none");
      AEBaseReportParam.a().i("1");
      AEBaseReportParam.a().d(0);
      Object localObject;
      if (paramAEMaterialMetaData != null)
      {
        AEBaseDataReporter.a().d(paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
        AEQLog.b("AEMaterialAdapter", "【Select Material】：" + paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
        AEQLog.b("AEMaterialAdapter", "【Select Material】Usable :" + paramAEMaterialMetaData.e);
        if ((paramAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!AEMaterialMetaData.a(paramAEMaterialMetaData))) {
          break label240;
        }
        if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener != null) {
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener.a();
        }
        paramAEMaterialMetaData = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
        localObject = AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
        if (this.jdField_a_of_type_Boolean) {
          break label235;
        }
      }
      for (;;)
      {
        paramAEMaterialMetaData.a((AEMaterialMetaData)localObject, bool1);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().removeExtra("widgetinfo");
        return;
        AEBaseDataReporter.a().d("null");
        AEQLog.b("AEMaterialAdapter", "【Select Material】：null");
        break;
        label235:
        bool1 = false;
      }
      label240:
      if (paramAEMaterialMetaData.a())
      {
        WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAEMaterialMetaData);
        return;
      }
      if (paramAEMaterialMetaData.e)
      {
        if (!AEResUtil.a())
        {
          QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709793), 0).a();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          ((AEMaterialManager)localObject).a(paramAEMaterialMetaData, bool1);
          if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener != null) {
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener.a(paramAEMaterialMetaData);
          }
          QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label423;
        }
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (!AECameraEntry.k(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent()))) {
          break label425;
        }
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.b(paramAEMaterialMetaData);
        return;
        bool1 = false;
        break;
        c(paramAEMaterialMetaData);
      }
    }
    label425:
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialMetaData);
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
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) && (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.equals(paramAEMaterialMetaData)))
    {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b = false;
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c = false;
    }
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {}
    while ((paramAEMaterialMetaData.f) || (TextUtils.isEmpty(paramAEMaterialMetaData.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager == null)) {
      return;
    }
    d(paramAEMaterialMetaData);
  }
  
  private void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    a(paramAEMaterialMetaData, a(paramAEMaterialMetaData));
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
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
    if (paramInt == 113) {
      if (AEMaterialManager.a() != null) {
        notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt == 1024)
          {
            QLog.d("AEMaterialAdapter", 4, "current watermark has change");
            notifyDataSetChanged();
            return;
          }
          if (paramInt != 111) {
            break;
          }
        } while ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!this.jdField_a_of_type_Boolean));
        a(((AEMaterialCategory)paramVarArgs[0]).a);
        notifyDataSetChanged();
        return;
        if (paramInt != 114) {
          break;
        }
      } while ((paramVarArgs == null) || (paramVarArgs.length != 1));
      a(true, paramVarArgs[0]);
      return;
    } while ((paramInt != 115) || (paramVarArgs == null) || (paramVarArgs.length != 1));
    a(false, paramVarArgs[0]);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localAEMaterialMetaData == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      AEBaseDataReporter.a().h(localAEMaterialMetaData.jdField_a_of_type_JavaLangString);
      Object localObject;
      if ((paramViewHolder instanceof MaterialNoneViewHolder))
      {
        localObject = (MaterialNoneViewHolder)paramViewHolder;
        if ((AEMaterialManager.a() == null) || (localAEMaterialMetaData.equals(AEMaterialManager.a()))) {
          ((MaterialNoneViewHolder)localObject).a();
        } else {
          ((MaterialNoneViewHolder)localObject).b();
        }
      }
      else if ((paramViewHolder instanceof MaterialViewHolder))
      {
        localObject = (MaterialViewHolder)paramViewHolder;
        if ((localAEMaterialMetaData.equals(AEMaterialManager.a())) && (localAEMaterialMetaData.e))
        {
          ((MaterialViewHolder)localObject).a(2, localAEMaterialMetaData);
        }
        else
        {
          localAEMaterialMetaData.jdField_a_of_type_Boolean = false;
          ((MaterialViewHolder)localObject).a(1, localAEMaterialMetaData);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEGridView.getChildAdapterPosition(paramView);
    if (i == -1)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    b(localAEMaterialMetaData);
    if (localAEMaterialMetaData.b) {
      localAEMaterialMetaData.c = true;
    }
    for (;;)
    {
      a(localAEMaterialMetaData, i);
      if (!AECameraEntry.k(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent())) {
        break;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext2", localAEMaterialMetaData.jdField_a_of_type_JavaLangString);
      AEReportUtils.b(5, localHashMap);
      break;
      localAEMaterialMetaData.b = true;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558521, paramViewGroup, false);
      paramViewGroup = new MaterialNoneViewHolder(localView);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return paramViewGroup;
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558520, paramViewGroup, false);
      paramViewGroup = new MaterialViewHolder(localView);
      paramViewGroup.a(this.jdField_a_of_type_AndroidContentContext);
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
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    } while (paramBoolean);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = a(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */