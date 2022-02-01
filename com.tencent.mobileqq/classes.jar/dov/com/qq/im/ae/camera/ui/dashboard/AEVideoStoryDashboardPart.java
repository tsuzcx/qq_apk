package dov.com.qq.im.ae.camera.ui.dashboard;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AEVideoStoryDashboardPart
  extends VideoStoryBasePart
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_a_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_b_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_c_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private AEVideoStoryDashboardPart.DashboardAdapter jdField_d_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter;
  
  public AEVideoStoryDashboardPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.2(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.3(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.4(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.5(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.jdField_b_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.jdField_c_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.jdField_d_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter);
  }
  
  private void c()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new AEVideoStoryDashboardPart.6(this));
  }
  
  private void d()
  {
    AEDashboardUtil.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryDashboardPart.7(this));
  }
  
  public void initView()
  {
    View localView = ((ViewStub)this.mRootView.findViewById(2131362267)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362272));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362273));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362270));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362275));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362278));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131362277));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362269));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362274));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362268));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131362276));
    a();
    b();
    c();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AEVideoStoryDashboardPart.1(this));
    d();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject3;
    if (paramInt == 720897)
    {
      localObject2 = (List)paramVarArgs[0];
      localObject1 = (List)paramVarArgs[1];
      paramVarArgs = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEDashboardUtil.BinaryInfo)((Iterator)localObject2).next();
        localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
        localDashboardInfo.a = AEVideoStoryDashboardPart.MessageRenderUtil.a((AEDashboardUtil.BinaryInfo)localObject3);
        paramVarArgs.add(localDashboardInfo);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (AEDashboardUtil.ABTestInfo)((Iterator)localObject1).next();
        localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
        localDashboardInfo.a = ((AEDashboardUtil.ABTestInfo)localObject3).toString();
        ((List)localObject2).add(localDashboardInfo);
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter.a(paramVarArgs);
      this.jdField_c_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter.a((List)localObject2);
    }
    while ((paramInt != 720898) || (this.jdField_d_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter == null))
    {
      AEVideoStoryDashboardPart.DashboardInfo localDashboardInfo;
      return;
    }
    Object localObject1 = AEDashboardUtil.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new AEVideoStoryDashboardPart.DashboardInfo(null);
      ((AEVideoStoryDashboardPart.DashboardInfo)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_DovComQqImAeCameraUiDashboardAEVideoStoryDashboardPart$DashboardAdapter.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart
 * JD-Core Version:    0.7.0.1
 */