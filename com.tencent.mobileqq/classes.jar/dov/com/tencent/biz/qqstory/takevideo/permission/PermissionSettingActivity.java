package dov.com.tencent.biz.qqstory.takevideo.permission;

import aloz;
import alpo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awbv;
import bmvx;
import bmvz;
import bmwa;
import bmwc;
import bmwd;
import bmwh;
import bmwi;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uhl;
import wsv;
import wta;
import xod;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private bmwd jdField_a_of_type_Bmwd;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private bmwa a(Groups paramGroups, List<awbv> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new bmvz(localFriends));
        }
      }
    }
    return new bmwa(paramGroups, localArrayList);
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131375812);
    super.setTitle(alpo.a(2131708314));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(alpo.a(2131708307));
    this.rightViewText.setContentDescription(alpo.a(2131708309));
    this.rightViewText.setOnClickListener(new bmwh(this));
  }
  
  private void a(int paramInt)
  {
    wsv.b("Q.qqstory.QQStoryBaseActivity", "permissionReport type:" + paramInt);
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      wta.a("qim_pub", "clk_set_suc", 0, 0, new String[] { str });
      return;
      str = "0";
      continue;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      wsv.e("Q.qqstory.QQStoryBaseActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((uhl)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    wsv.a("Q.qqstory.QQStoryBaseActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
    ((List)localObject4).add(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject4).add(((QQStoryUserInfo)((Iterator)localObject1).next()).uin);
      }
    }
    localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject5 = (aloz)this.app.getManager(51);
    Object localObject6 = ((aloz)localObject5).e();
    if (localObject6 != null)
    {
      wsv.a("Q.qqstory.QQStoryBaseActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (awbv)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((aloz)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((bmwa)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((bmwa)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    wsv.e("Q.qqstory.QQStoryBaseActivity", "friends group list is null! ");
    localObject4 = new bmwc(this, xod.a(this, 20.0F));
    ((bmwc)localObject4).a(false, true);
    localObject5 = new bmwi(this, getString(2131699896), "", 10004);
    ((bmwi)localObject5).c(true);
    localObject6 = new bmwi(this, getString(2131699888), "", 10000);
    ((bmwi)localObject6).c(true);
    Object localObject7 = new bmwi(this, getString(2131699892), "", 10001);
    ((bmwi)localObject7).c(false);
    Object localObject8 = new bmwc(this, xod.a(this, 20.0F));
    ((bmwc)localObject8).a(true, true);
    localObject3 = new bmvx(this, getString(2131699895), "", 10002, (List)localObject3, this.app);
    localObject2 = new bmvx(this, getString(2131699894), "", 10003, (List)localObject2, this.app);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((List)localObject1).add(localObject4);
      ((List)localObject1).add(localObject5);
      ((List)localObject1).add(localObject6);
      ((List)localObject1).add(localObject7);
      ((List)localObject1).add(localObject8);
      ((List)localObject1).add(localObject3);
      ((List)localObject1).add(localObject2);
      paramList = this.jdField_a_of_type_ComTencentWidgetListView;
      localObject1 = new bmwd((List)localObject1);
      this.jdField_a_of_type_Bmwd = ((bmwd)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Bmwd);
      return;
      ((bmwi)localObject5).b(true);
      continue;
      ((bmwi)localObject6).b(true);
      continue;
      ((bmwi)localObject7).b(true);
      continue;
      ((bmvx)localObject3).b(true);
      ((bmvx)localObject3).a(paramList);
      continue;
      ((bmvx)localObject2).b(true);
      ((bmvx)localObject2).a(paramList);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null)) {}
  }
  
  public boolean onBackEvent()
  {
    wta.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559043);
    a();
    Intent localIntent = getIntent();
    int i;
    if (localIntent != null)
    {
      i = localIntent.getIntExtra("PERMISSION_TYPE_KEY", 10000);
      paramBundle = localIntent.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PERMISSION_HAS_TAG_KEY", false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131371695));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131166959));
      wta.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */