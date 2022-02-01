package dov.com.tencent.biz.qqstory.takevideo.permission;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anyw;
import anzj;
import bqtk;
import bqtm;
import bqtn;
import bqtp;
import bqtq;
import bqtu;
import bqtv;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wjb;
import yuk;
import yup;
import zps;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private bqtq jdField_a_of_type_Bqtq;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private bqtn a(Groups paramGroups, List<Entity> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new bqtm(localFriends));
        }
      }
    }
    return new bqtn(paramGroups, localArrayList);
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131376731);
    super.setTitle(anzj.a(2131706812));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(anzj.a(2131706805));
    this.rightViewText.setContentDescription(anzj.a(2131706807));
    this.rightViewText.setOnClickListener(new bqtu(this));
  }
  
  private void a(int paramInt)
  {
    yuk.b("Q.qqstory.QQStoryBaseActivity", "permissionReport type:" + paramInt);
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      yup.a("qim_pub", "clk_set_suc", 0, 0, new String[] { str });
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
      yuk.e("Q.qqstory.QQStoryBaseActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((wjb)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    yuk.a("Q.qqstory.QQStoryBaseActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (anyw)this.app.getManager(51);
    Object localObject6 = ((anyw)localObject5).e();
    if (localObject6 != null)
    {
      yuk.a("Q.qqstory.QQStoryBaseActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((anyw)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((bqtn)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((bqtn)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    yuk.e("Q.qqstory.QQStoryBaseActivity", "friends group list is null! ");
    localObject4 = new bqtp(this, zps.a(this, 20.0F));
    ((bqtp)localObject4).a(false, true);
    localObject5 = new bqtv(this, getString(2131698456), "", 10004);
    ((bqtv)localObject5).c(true);
    localObject6 = new bqtv(this, getString(2131698452), "", 10000);
    ((bqtv)localObject6).c(true);
    Object localObject7 = new bqtv(this, getString(2131698453), "", 10001);
    ((bqtv)localObject7).c(false);
    Object localObject8 = new bqtp(this, zps.a(this, 20.0F));
    ((bqtp)localObject8).a(true, true);
    localObject3 = new bqtk(this, getString(2131698455), "", 10002, (List)localObject3, this.app);
    localObject2 = new bqtk(this, getString(2131698454), "", 10003, (List)localObject2, this.app);
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
      localObject1 = new bqtq((List)localObject1);
      this.jdField_a_of_type_Bqtq = ((bqtq)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Bqtq);
      return;
      ((bqtv)localObject5).b(true);
      continue;
      ((bqtv)localObject6).b(true);
      continue;
      ((bqtv)localObject7).b(true);
      continue;
      ((bqtk)localObject3).b(true);
      ((bqtk)localObject3).a(paramList);
      continue;
      ((bqtk)localObject2).b(true);
      ((bqtk)localObject2).a(paramList);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null)) {}
  }
  
  public boolean onBackEvent()
  {
    yup.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559109);
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
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131372403));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131167050));
      yup.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */