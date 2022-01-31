package dov.com.tencent.biz.qqstory.takevideo.poilist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;

public class SearchPoiListActivity
  extends QQStoryBaseActivity
  implements PoiListLayout.PoiListEventListener, SearchPoiListLayout.SearchPoiListEventListener
{
  private TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
  private PoiListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout;
  private SearchPoiListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout;
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout.d();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout.f();
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    Intent localIntent = new Intent();
    if (paramTroopBarPOI != null)
    {
      localIntent.putExtra("choose_poi", paramTroopBarPOI);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      setResult(0);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout.e();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout.e();
  }
  
  public void b(TroopBarPOI paramTroopBarPOI)
  {
    Intent localIntent = new Intent(this, PermissionSettingActivity.class);
    if (paramTroopBarPOI != null)
    {
      localIntent.putExtra("choose_poi", paramTroopBarPOI);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      setResult(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970842);
    super.setTitle("所在位置");
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(8);
    setLeftViewName(2131433712);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout = new PoiListLayout(findViewById(2131371615), this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout = new SearchPoiListLayout(findViewById(2131371995), this);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramBundle.getParcelableExtra("curr_poi"));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout.a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.poilist.SearchPoiListActivity
 * JD-Core Version:    0.7.0.1
 */