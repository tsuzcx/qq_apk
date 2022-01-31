package dov.com.tencent.biz.qqstory.takevideo.poilist;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aolu;
import aolv;
import aoly;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.qq.im.capture.poi.FacePoiManager.FacePoiListener;
import java.util.ArrayList;
import java.util.List;

public class PoiListLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener, FacePoiManager.FacePoiListener
{
  public long a;
  private final View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private FacePoiManager jdField_a_of_type_DovComQqImCapturePoiFacePoiManager;
  private PoiListAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter;
  private PoiListLayout.PoiListEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout$PoiListEventListener;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private View c;
  private View d;
  
  public PoiListLayout(@NonNull View paramView, @NonNull PoiListLayout.PoiListEventListener paramPoiListEventListener)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout$PoiListEventListener = paramPoiListEventListener;
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager = new FacePoiManager(this);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.a = false;
        new Handler(Looper.getMainLooper()).postDelayed(new aoly(this), 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371952);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371953);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371955));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371956));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371954));
    b();
    c();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new aolu(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter = new PoiListAdapter(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(), this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a());
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(true);
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
        this.jdField_a_of_type_AndroidViewView.getContext().getString(2131432519);
        return;
        this.jdField_a_of_type_AndroidViewView.getContext().getString(2131432518);
      } while ((paramVarArgs == null) || (paramVarArgs.length <= 0));
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramVarArgs[0], 1).a();
      return;
    case 2: 
      this.jdField_a_of_type_AndroidViewView.getContext().getString(2131432517);
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
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(paramTroopBarPOI);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(paramInt)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter == null)) {
      return;
    }
    paramView = (TroopBarPOI)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.a().get(paramInt);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(paramView);
    f();
    if (paramView != null) {
      if (TextUtils.isEmpty(paramView.c))
      {
        paramAdapterView = paramView.d;
        a(1, new String[] { paramAdapterView });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout$PoiListEventListener.a(paramView);
      return;
      paramAdapterView = paramView.c;
      break;
      a(0, new String[0]);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131363969);
    if (paramBoolean)
    {
      localTextView.setText(2131434366);
      return;
    }
    localTextView.setText(2131434362);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    if (paramBoolean1)
    {
      a(paramBoolean2);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter != null)
      {
        if ((paramArrayList != null) && (paramArrayList.size() > 0) && (!PoiListAdapter.a.c.equals(((TroopBarPOI)paramArrayList.get(0)).c))) {
          paramArrayList.add(0, PoiListAdapter.a);
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.a(paramArrayList, paramTroopBarPOI);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.notifyDataSetChanged();
        if ((paramArrayList != null) && (paramArrayList.isEmpty())) {
          a(false, false);
        }
      }
      else
      {
        if (paramTroopBarPOI == null) {
          break label146;
        }
        if (!TextUtils.isEmpty(paramTroopBarPOI.c)) {
          break label137;
        }
      }
      label137:
      for (paramArrayList = paramTroopBarPOI.d;; paramArrayList = paramTroopBarPOI.c)
      {
        a(1, new String[] { paramArrayList });
        return;
        a(true, false);
        break;
      }
      label146:
      a(0, new String[0]);
      return;
    }
    a(3, new String[0]);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2130969237, null, false));
    }
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-16777216, -16777216, -16777216, -16777216, -16777216);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgDrawable(this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838219));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new aolv(this));
  }
  
  protected void c()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2130969237, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131363318);
      TextView localTextView1 = (TextView)this.d.findViewById(2131363969);
      TextView localTextView2 = (TextView)this.d.findViewById(2131363970);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131363054);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131434362);
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
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a(), this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131371954: 
    case 2131371955: 
    default: 
      return;
    case 2131371952: 
    case 2131371953: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout$PoiListEventListener.a();
      return;
    }
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager.a();
    a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.poilist.PoiListLayout
 * JD-Core Version:    0.7.0.1
 */