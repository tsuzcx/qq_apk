package dov.com.qq.im.capture.poi;

import amxe;
import amxf;
import amxg;
import amxj;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import dov.com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class FacePoiUI
  implements View.OnClickListener, AdapterView.OnItemClickListener, FacePoiManager.FacePoiListener
{
  public long a;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  private FacePoiManager jdField_a_of_type_DovComQqImCapturePoiFacePoiManager = new FacePoiManager(this);
  private FacePoiUI.FacePoiUIListener jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener;
  QQStoryPoiListAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = null;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  View c = null;
  View d = null;
  public View e;
  
  public FacePoiUI()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.a = false;
        new Handler(Looper.getMainLooper()).postDelayed(new amxj(this), 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public FacePoiManager a()
  {
    return this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363227));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371774);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371775);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371777));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371778));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363363)).setText("所在位置");
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371776));
      b();
      c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new amxe(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = new QQStoryPoiListAdapter(this.e.getContext());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(), this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a());
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 3: 
      do
      {
        return;
        this.e.getContext().getString(2131432491);
        return;
        this.e.getContext().getString(2131432490);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          QQToast.a(this.e.getContext(), paramVarArgs[0], 1).a();
        }
      } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0));
      a(false, false);
      return;
    case 2: 
      this.e.getContext().getString(2131432489);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
    {
      if (TextUtils.isEmpty(paramVarArgs[0]))
      {
        a(3, new String[0]);
        return;
      }
      paramVarArgs = paramVarArgs[0];
      return;
    }
    a(0, new String[0]);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("FacePoiUI rootView can't be null");
    }
    this.e = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.e.findViewById(2131364328));
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(paramInt)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter == null)) {
      return;
    }
    paramView = (TroopBarPOI)this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a().get(paramInt);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(paramView);
    e();
    EditVideoPoiPickerCallback localEditVideoPoiPickerCallback = this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a();
    if (paramView != null) {
      if (TextUtils.isEmpty(paramView.c))
      {
        paramAdapterView = paramView.d;
        a(1, new String[] { paramAdapterView });
        if (localEditVideoPoiPickerCallback != null) {
          localEditVideoPoiPickerCallback.a(paramView);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener == null) {
        break label150;
      }
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener.c();
      return;
      paramAdapterView = paramView.c;
      break;
      a(0, new String[0]);
      if (localEditVideoPoiPickerCallback != null) {
        localEditVideoPoiPickerCallback.a(null);
      }
    }
    label150:
    d();
  }
  
  public void a(FacePoiUI.FacePoiUIListener paramFacePoiUIListener)
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener = paramFacePoiUIListener;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131363921);
    if (paramBoolean)
    {
      localTextView.setText(2131434333);
      return;
    }
    localTextView.setText(2131434329);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramBoolean1, paramBoolean2);
      return;
    }
    ThreadManager.getUIHandler().post(new amxf(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    if (paramBoolean1)
    {
      a(paramBoolean2);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(paramArrayList, paramTroopBarPOI);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
        if (paramArrayList.isEmpty()) {
          a(false, false);
        }
      }
      else
      {
        if (paramTroopBarPOI == null) {
          break label100;
        }
        if (!TextUtils.isEmpty(paramTroopBarPOI.c)) {
          break label91;
        }
      }
      label91:
      for (paramArrayList = paramTroopBarPOI.d;; paramArrayList = paramTroopBarPOI.c)
      {
        a(1, new String[] { paramArrayList });
        return;
        a(true, false);
        break;
      }
      label100:
      a(0, new String[0]);
      return;
    }
    a(3, new String[0]);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.e.getContext()).inflate(2130969238, null, false));
    }
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new amxg(this));
  }
  
  protected void c()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.e.getContext()).inflate(2130969238, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131363283);
      TextView localTextView1 = (TextView)this.d.findViewById(2131363921);
      TextView localTextView2 = (TextView)this.d.findViewById(2131363922);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131363031);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131434329);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(), this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363227: 
    case 2131371774: 
    case 2131371775: 
      do
      {
        return;
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.c();
        if (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener != null)
        {
          this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener.aA_();
          return;
        }
        d();
        return;
      } while (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener == null);
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener.b();
      return;
    }
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a();
    a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.poi.FacePoiUI
 * JD-Core Version:    0.7.0.1
 */