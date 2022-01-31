package dov.com.tencent.biz.qqstory.takevideo.shareto;

import ajjy;
import akeu;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bbmy;
import behi;
import bivu;
import bivv;
import bivw;
import bivx;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tfy;
import urp;

public class ShareToActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, behi, bivw
{
  protected bivv a;
  protected XListView a;
  
  private ArrayList<TroopInfo> a()
  {
    QQAppInterface localQQAppInterface = tfy.a();
    Object localObject2 = (TroopManager)localQQAppInterface.getManager(52);
    Object localObject1 = ((TroopManager)localObject2).a();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject1).size());
    Object localObject4 = localQQAppInterface.a().a().a(false);
    Object localObject3 = new ArrayList();
    localObject4 = ((List)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject4).next();
      if (localRecentUser.getType() == 1) {
        ((ArrayList)localObject3).add(localRecentUser);
      }
    }
    Collections.sort((List)localObject3, new bivu(this));
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((TroopManager)localObject2).c(((RecentUser)((Iterator)localObject3).next()).uin);
      if ((localObject4 != null) && (((TroopInfo)localObject4).troopuin != null)) {
        localArrayList.add(localObject4);
      }
    }
    localObject2 = new ArrayList();
    localObject3 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (TroopInfo)((Iterator)localObject1).next();
      if (!localArrayList.contains(localObject4))
      {
        int i = localQQAppInterface.b(((TroopInfo)localObject4).troopuin);
        if (i == 3) {
          ((ArrayList)localObject2).add(localObject4);
        } else if (i == 2) {
          ((ArrayList)localObject3).add(localObject4);
        } else {
          localArrayList.add(localObject4);
        }
      }
    }
    localArrayList.addAll((Collection)localObject3);
    localArrayList.addAll((Collection)localObject2);
    return localArrayList;
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = this.jdField_a_of_type_Bivv.a();
    }
    int i = ((ArrayList)localObject).size();
    if (i > 0)
    {
      this.rightViewText.setText(ajjy.a(2131648180) + i + ")");
      return;
    }
    this.rightViewText.setText(ajjy.a(2131648182));
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    b(paramArrayList);
  }
  
  public boolean a(ArrayList<String> paramArrayList, bivx parambivx)
  {
    if ((!parambivx.a) && (paramArrayList.size() >= 10))
    {
      bbmy.a(tfy.a(), 0, "最多只能选择10个群", 0).a();
      return false;
    }
    return true;
  }
  
  public boolean onBackEvent()
  {
    urp.a("story_grp", "share_return", 0, 0, new String[] { "", "", "", "" });
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    urp.a("story_grp", "share_suc", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Bivv.a().size()), "", "", "" });
    paramView = new Intent();
    paramView.putStringArrayListExtra("share_to_group_key", this.jdField_a_of_type_Bivv.a());
    setResult(1, paramView);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131495751);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131310249));
    paramBundle = getLayoutInflater().inflate(2131495752, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("share_to_group_key");
    ArrayList localArrayList = a();
    this.jdField_a_of_type_Bivv = new bivv(getBaseContext(), localArrayList, paramBundle);
    this.jdField_a_of_type_Bivv.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bivv);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    super.setTitle(ajjy.a(2131648181));
    super.a(ajjy.a(2131648175), this);
    b(null);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (paramBundle = "2";; paramBundle = "1")
    {
      urp.a("story_grp", "exp_share", 0, 0, new String[] { paramBundle, "", "", "" });
      return;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong <= -1L) {}
    do
    {
      return;
      paramInt = (int)paramLong;
      paramAdapterView = (bivx)this.jdField_a_of_type_Bivv.getItem(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Bivv.a(paramAdapterView);
    urp.a("story_grp", "clk_share", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity
 * JD-Core Version:    0.7.0.1
 */