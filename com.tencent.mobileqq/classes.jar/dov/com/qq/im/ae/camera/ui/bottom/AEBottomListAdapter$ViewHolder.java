package dov.com.qq.im.ae.camera.ui.bottom;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;

public class AEBottomListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  public AEMaterialMetaData a;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public AEBottomListAdapter$ViewHolder(View paramView, AEBottomListScrollView paramAEBottomListScrollView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381505));
    this.d = ((ImageView)paramView.findViewById(2131381512));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381518);
    this.b = ((ImageView)paramView.findViewById(2131381519));
    this.c = ((ImageView)paramView.findViewById(2131381514));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381571));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)AEBottomListAdapter.a().get(5);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)AEBottomListAdapter.a().get(6);
    }
    if (AEBottomListAdapter.b()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)AEBottomListAdapter.a().get(paramInt);
      paramInt = (paramInt - 1 - 1) % 4;
      continue;
      paramInt = (paramInt - 1) % 4;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidViewView == null);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        } while (this.jdField_a_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 3: 
      if ((this.c != null) && (!this.jdField_a_of_type_Boolean)) {
        this.c.setVisibility(0);
      }
      if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (!"0".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
    }
    if (this.c != null) {
      this.c.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString))) {
        break label273;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        break label262;
      }
      if (!"0".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) {
        break label198;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b()) {
        break label641;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      paramAEMaterialMetaData = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378926, paramAEMaterialMetaData);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378891, Boolean.valueOf(false));
      if (!this.jdField_a_of_type_Boolean) {
        break label683;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(AEBottomListAdapter.c);
      return;
      label198:
      this.d.setVisibility(0);
      UIUtils.a(this.d, "https://downv6.qq.com/shadow_qqcamera/Android/image/material_more.png", UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), this.itemView.getContext().getResources().getDrawable(2130851275), null);
      break;
      label262:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label273:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844721);
        break;
      }
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131378926, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c);
        this.d.setTag(2131378891, Boolean.valueOf(false));
        UIUtils.a(this.d, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), this.itemView.getContext().getResources().getDrawable(2130844721), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130846263);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131378926, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c);
      this.d.setTag(2131378891, Boolean.valueOf(false));
      UIUtils.a(this.d, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.a()), this.itemView.getContext().getResources().getDrawable(2130844721), null);
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.e) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.f) {
          a(1);
        } else {
          a(0);
        }
      }
      label641:
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130846263);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
    label683:
    UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, paramAEMaterialMetaData, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.b()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.b()), this.itemView.getContext().getResources().getDrawable(2130851275), null);
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      AEBottomListAdapter.a = AEBottomListAdapter.b;
      AEBottomListAdapter.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
      if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter() instanceof AEBottomListAdapter)) {
        ((AEBottomListAdapter)this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter()).a(true);
      }
    }
    if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) && ("call_material_id".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)))
    {
      AEBaseDataReporter.a().V();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AEBaseReportParam.a().j("none");
    AEBaseReportParam.a().i("2");
    AEBaseReportParam.a().d(0);
    label131:
    Object localObject2;
    if (i == 0)
    {
      AEBaseReportParam.a().c(-1);
      localObject2 = AEBaseDataReporter.a();
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) {
        break label242;
      }
      localObject1 = "";
      label146:
      ((AEBaseDataReporter)localObject2).d((String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) {
        break label253;
      }
      localObject1 = "";
      label176:
      AEQLog.b("AEBottomListAdapter", (String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) {
        break label264;
      }
    }
    label264:
    for (Object localObject1 = "";; localObject1 = Boolean.valueOf(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.e))
    {
      AEQLog.b("AEBottomListAdapter", localObject1);
      break;
      AEBaseReportParam.a().c(i);
      break label131;
      label242:
      localObject1 = this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString;
      break label146;
      label253:
      localObject1 = this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString;
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */