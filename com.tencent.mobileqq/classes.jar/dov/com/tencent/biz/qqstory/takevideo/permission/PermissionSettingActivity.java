package dov.com.tencent.biz.qqstory.takevideo.permission;

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
import aocy;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private PermissionListAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoPermissionPermissionListAdapter;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private ComplexPart.Group a(Groups paramGroups, List paramList1, @NonNull List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        Friends localFriends = (Friends)paramList1.next();
        if (!paramList2.contains(localFriends.uin)) {
          localArrayList.add(new ComplexPart.Friend(localFriends));
        }
      }
    }
    return new ComplexPart.Group(paramGroups, localArrayList);
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131363244);
    super.setTitle("谁能看见");
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText("完成");
    this.rightViewText.setContentDescription("完成");
    this.rightViewText.setOnClickListener(new aocy(this));
  }
  
  private void a(int paramInt)
  {
    SLog.b("Q.qqstory.QQStoryBaseActivity", "permissionReport type:" + paramInt);
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      StoryReportor.a("qim_pub", "clk_set_suc", 0, 0, new String[] { str });
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
  
  private void a(int paramInt, List paramList)
  {
    if (this.app == null)
    {
      SLog.e("Q.qqstory.QQStoryBaseActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((QQStoryManager)this.app.getManager(180)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    SLog.a("Q.qqstory.QQStoryBaseActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (FriendsManager)this.app.getManager(50);
    Object localObject6 = ((FriendsManager)localObject5).d();
    if (localObject6 != null)
    {
      SLog.a("Q.qqstory.QQStoryBaseActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((FriendsManager)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((ComplexPart.Group)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((ComplexPart.Group)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    SLog.e("Q.qqstory.QQStoryBaseActivity", "friends group list is null! ");
    localObject4 = new EmptyPart(this, UIUtils.a(this, 20.0F));
    ((EmptyPart)localObject4).a(false, true);
    localObject5 = new SinglePart(this, getString(2131438714), "", 10004);
    ((SinglePart)localObject5).c(true);
    localObject6 = new SinglePart(this, getString(2131438715), "", 10000);
    ((SinglePart)localObject6).c(true);
    Object localObject7 = new SinglePart(this, getString(2131438716), "", 10001);
    ((SinglePart)localObject7).c(false);
    Object localObject8 = new EmptyPart(this, UIUtils.a(this, 20.0F));
    ((EmptyPart)localObject8).a(true, true);
    localObject3 = new ComplexPart(this, getString(2131438717), "", 10002, (List)localObject3, this.app);
    localObject2 = new ComplexPart(this, getString(2131438718), "", 10003, (List)localObject2, this.app);
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
      localObject1 = new PermissionListAdapter((List)localObject1);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPermissionPermissionListAdapter = ((PermissionListAdapter)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPermissionPermissionListAdapter);
      return;
      ((SinglePart)localObject5).b(true);
      continue;
      ((SinglePart)localObject6).b(true);
      continue;
      ((SinglePart)localObject7).b(true);
      continue;
      ((ComplexPart)localObject3).b(true);
      ((ComplexPart)localObject3).a(paramList);
      continue;
      ((ComplexPart)localObject2).b(true);
      ((ComplexPart)localObject2).a(paramList);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null)) {}
  }
  
  protected boolean onBackEvent()
  {
    StoryReportor.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968957);
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
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131364404));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131494255));
      StoryReportor.a("pub_control", "exp_page", 0, 0, new String[0]);
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