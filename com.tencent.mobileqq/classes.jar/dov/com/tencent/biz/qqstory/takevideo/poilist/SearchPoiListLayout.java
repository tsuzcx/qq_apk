package dov.com.tencent.biz.qqstory.takevideo.poilist;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import anmz;
import anna;
import annb;
import annc;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SearchPoiListLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new annc(this);
  private final View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LbsManager.POIListRequestSession jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = LbsManager.POIListRequestSession.a();
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private PoiListAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter;
  private SearchPoiListLayout.SearchPoiListEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout$SearchPoiListEventListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public SearchPoiListLayout(@NonNull View paramView, @NonNull SearchPoiListLayout.SearchPoiListEventListener paramSearchPoiListEventListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout$SearchPoiListEventListener = paramSearchPoiListEventListener;
  }
  
  private void g()
  {
    SLog.b("SearchPoiListLayout", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a(str);
    if (TextUtils.isEmpty(str))
    {
      SLog.c("SearchPoiListLayout", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.notifyDataSetChanged();
      d();
      return;
    }
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = LbsManager.a();
    if (localBasicLocation != null) {
      localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, new annb(this, str));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b())
    {
      c();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void a()
  {
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131371781);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371779));
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371780);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371776));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371782);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131371783);
    this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131371784);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371785));
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter = new PoiListAdapter(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new anmz(this));
    b();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.post(new anna(this));
    this.d.setVisibility(4);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout$SearchPoiListEventListener.b(paramAdapterView);
      InputMethodUtil.b(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.g.setVisibility(0);
    paramString = this.jdField_a_of_type_AndroidViewView.getResources().getString(2131432074, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
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
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
    {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidViewView);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2130969238, null);
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
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371781: 
    case 2131371782: 
      InputMethodUtil.b(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout$SearchPoiListEventListener.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.poilist.SearchPoiListLayout
 * JD-Core Version:    0.7.0.1
 */