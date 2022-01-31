package dov.com.qq.im.capture.poi;

import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import annf;
import anng;
import annh;
import anni;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import dov.com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FacePoiSearchUI
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new anni(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public LbsManager.POIListRequestSession a;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  private FacePoiSearchUI.FacePoiSearchUIListener jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  public QQStoryPoiListAdapter a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList a;
  View b;
  View c;
  public View d = null;
  View e = null;
  View f = null;
  View g = null;
  public View h;
  
  public FacePoiSearchUI()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = LbsManager.POIListRequestSession.a();
  }
  
  private void g()
  {
    SLog.b("FacePoiSearchUI", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a(str);
    if (TextUtils.isEmpty(str))
    {
      SLog.c("FacePoiSearchUI", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
      d();
      return;
    }
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = LbsManager.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localBasicLocation = LocationUtils.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localBasicLocation != null) {
      localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, new annh(this, str));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b())
    {
      c();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public EditVideoPoiPickerCallback a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      throw new IllegalStateException("EditVideoPoiPickerCallback is null");
    }
    return (EditVideoPoiPickerCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131371951);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371949));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371950);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371946));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371952);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131371953);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131371954);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371955));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = new QQStoryPoiListAdapter(this.h.getContext());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new annf(this));
      b();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.post(new anng(this));
    this.d.setVisibility(4);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("FacePoiSearchUI rootView can't be null");
    }
    this.h = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.h.findViewById(2131364353));
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView = (EditVideoPoiPickerCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener != null)) {
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener.aD_();
      }
      InputMethodUtil.b(this.h);
    }
  }
  
  public void a(FacePoiSearchUI.FacePoiSearchUIListener paramFacePoiSearchUIListener)
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener = paramFacePoiSearchUIListener;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(EditVideoPoiPickerCallback paramEditVideoPoiPickerCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEditVideoPoiPickerCallback);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.g.setVisibility(0);
    paramString = this.h.getResources().getString(2131432091, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131363944);
    if (paramBoolean)
    {
      localTextView.setText(2131434350);
      return;
    }
    localTextView.setText(2131434346);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      InputMethodUtil.b(this.h);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.h.getContext()).inflate(2130969239, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131363301);
      TextView localTextView1 = (TextView)this.d.findViewById(2131363944);
      TextView localTextView2 = (TextView)this.d.findViewById(2131363945);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131363049);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131434346);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.g.setVisibility(4);
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      InputMethodUtil.b(this.h);
      return;
      a();
      e();
    } while (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener == null);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener.aD_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.poi.FacePoiSearchUI
 * JD-Core Version:    0.7.0.1
 */