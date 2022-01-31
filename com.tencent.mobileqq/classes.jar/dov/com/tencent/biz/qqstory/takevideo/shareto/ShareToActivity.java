package dov.com.tencent.biz.qqstory.takevideo.shareto;

import alud;
import amnz;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bhuw;
import bnct;
import bncu;
import bncv;
import bncw;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vls;
import wxj;

public class ShareToActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, bhuw, bncv
{
  protected bncu a;
  protected XListView a;
  
  private ArrayList<TroopInfo> a()
  {
    QQAppInterface localQQAppInterface = vls.a();
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
    Collections.sort((List)localObject3, new bnct(this));
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
      localObject = this.jdField_a_of_type_Bncu.a();
    }
    int i = ((ArrayList)localObject).size();
    if (i > 0)
    {
      this.rightViewText.setText(alud.a(2131714363) + i + ")");
      return;
    }
    this.rightViewText.setText(alud.a(2131714365));
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    b(paramArrayList);
  }
  
  public boolean a(ArrayList<String> paramArrayList, bncw parambncw)
  {
    if ((!parambncw.a) && (paramArrayList.size() >= 10))
    {
      QQToast.a(vls.a(), 0, "最多只能选择10个群", 0).a();
      return false;
    }
    return true;
  }
  
  public boolean onBackEvent()
  {
    wxj.a("story_grp", "share_return", 0, 0, new String[] { "", "", "", "" });
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    wxj.a("story_grp", "share_suc", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Bncu.a().size()), "", "", "" });
    paramView = new Intent();
    paramView.putStringArrayListExtra("share_to_group_key", this.jdField_a_of_type_Bncu.a());
    setResult(1, paramView);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561549);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376571));
    paramBundle = getLayoutInflater().inflate(2131561550, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("share_to_group_key");
    ArrayList localArrayList = a();
    this.jdField_a_of_type_Bncu = new bncu(getBaseContext(), localArrayList, paramBundle);
    this.jdField_a_of_type_Bncu.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bncu);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    super.setTitle(alud.a(2131714364));
    super.a(alud.a(2131714358), this);
    b(null);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (paramBundle = "2";; paramBundle = "1")
    {
      wxj.a("story_grp", "exp_share", 0, 0, new String[] { paramBundle, "", "", "" });
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
      paramAdapterView = (bncw)this.jdField_a_of_type_Bncu.getItem(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Bncu.a(paramAdapterView);
    wxj.a("story_grp", "clk_share", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity
 * JD-Core Version:    0.7.0.1
 */