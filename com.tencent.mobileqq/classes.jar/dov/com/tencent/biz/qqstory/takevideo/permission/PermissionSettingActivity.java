package dov.com.tencent.biz.qqstory.takevideo.permission;

import ajjj;
import ajjy;
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
import atmo;
import bitj;
import bitl;
import bitm;
import bito;
import bitp;
import bitt;
import bitu;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sga;
import urk;
import urp;
import vms;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private bitp jdField_a_of_type_Bitp;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private bitm a(Groups paramGroups, List<atmo> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new bitl(localFriends));
        }
      }
    }
    return new bitm(paramGroups, localArrayList);
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131309578);
    super.setTitle(ajjy.a(2131642146));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(ajjy.a(2131642139));
    this.rightViewText.setContentDescription(ajjy.a(2131642141));
    this.rightViewText.setOnClickListener(new bitt(this));
  }
  
  private void a(int paramInt)
  {
    urk.b("Q.qqstory.QQStoryBaseActivity", "permissionReport type:" + paramInt);
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      urp.a("qim_pub", "clk_set_suc", 0, 0, new String[] { str });
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
      urk.e("Q.qqstory.QQStoryBaseActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((sga)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    urk.a("Q.qqstory.QQStoryBaseActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (ajjj)this.app.getManager(51);
    Object localObject6 = ((ajjj)localObject5).e();
    if (localObject6 != null)
    {
      urk.a("Q.qqstory.QQStoryBaseActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (atmo)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((ajjj)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((bitm)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((bitm)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    urk.e("Q.qqstory.QQStoryBaseActivity", "friends group list is null! ");
    localObject4 = new bito(this, vms.a(this, 20.0F));
    ((bito)localObject4).a(false, true);
    localObject5 = new bitu(this, getString(2131633748), "", 10004);
    ((bitu)localObject5).c(true);
    localObject6 = new bitu(this, getString(2131633740), "", 10000);
    ((bitu)localObject6).c(true);
    Object localObject7 = new bitu(this, getString(2131633744), "", 10001);
    ((bitu)localObject7).c(false);
    Object localObject8 = new bito(this, vms.a(this, 20.0F));
    ((bito)localObject8).a(true, true);
    localObject3 = new bitj(this, getString(2131633747), "", 10002, (List)localObject3, this.app);
    localObject2 = new bitj(this, getString(2131633746), "", 10003, (List)localObject2, this.app);
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
      localObject1 = new bitp((List)localObject1);
      this.jdField_a_of_type_Bitp = ((bitp)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Bitp);
      return;
      ((bitu)localObject5).b(true);
      continue;
      ((bitu)localObject6).b(true);
      continue;
      ((bitu)localObject7).b(true);
      continue;
      ((bitj)localObject3).b(true);
      ((bitj)localObject3).a(paramList);
      continue;
      ((bitj)localObject2).b(true);
      ((bitj)localObject2).a(paramList);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null)) {}
  }
  
  public boolean onBackEvent()
  {
    urp.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493441);
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
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131305683));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131101317));
      urp.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */