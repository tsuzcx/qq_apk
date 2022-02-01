package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class BulkSendMessageFragment$ListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public boolean a = true;
  public ArrayList<String> b = new ArrayList();
  
  public BulkSendMessageFragment$ListAdapter(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  public int getCount()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(this.b.size());
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    BulkSendMessageFragment.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.c.getBaseActivity()).inflate(2131624461, null);
      localViewHolder = new BulkSendMessageFragment.ViewHolder(localView);
      localViewHolder.a = ((ImageView)localView.findViewById(2131435219));
      localViewHolder.b = ((TextView)localView.findViewById(2131439121));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (BulkSendMessageFragment.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    localView.setVisibility(0);
    localView.setFocusable(false);
    TextView localTextView = localViewHolder.b;
    ImageView localImageView = localViewHolder.a;
    Object localObject3 = (FriendsManager)this.c.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramInt < this.b.size())
    {
      localImageView.setImageResource(2130846392);
      localTextView.setTextColor(this.c.getResources().getColor(2131168133));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)this.b.get(paramInt));
      Object localObject1 = "";
      ((StringBuilder)localObject2).append("");
      String str = ((StringBuilder)localObject2).toString();
      localViewHolder.c = str;
      localObject2 = ContactUtils.b(this.c.d, this.c.c, str);
      if (TextUtils.isEmpty(str))
      {
        if (localObject2 == null) {
          localObject2 = localObject1;
        }
        localTextView.setText((CharSequence)localObject2);
        localImageView.setImageDrawable(ImageUtil.j());
      }
      else
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((FriendsManager)localObject3).m(str);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((Friends)localObject3).isFriend()) {
                localObject1 = ContactUtils.a(this.c.d, str);
              }
            }
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = HardCodeUtil.a(2131899474);
        }
        localTextView.setText((CharSequence)localObject2);
        this.c.a(localViewHolder, null, true);
        localImageView.setTag(2131446818, str);
        localImageView.setTag(null);
      }
      localViewHolder.d.setTag(2131446792, null);
      localViewHolder.d.setOnClickListener(null);
    }
    else
    {
      localTextView.setText(this.c.getString(2131886199));
      localTextView.setTextColor(this.c.getResources().getColorStateList(2131167344));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839322);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(0));
      localViewHolder.d.setTag(2131446792, Integer.valueOf(0));
      localViewHolder.d.setOnClickListener(this);
    }
    if (AppSetting.e) {
      ViewCompat.setImportantForAccessibility(localImageView, 2);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (Integer)paramView.getTag(2131446792);
    if ((localObject != null) && (((Integer)localObject).intValue() == 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("troop_uin", this.c.c);
      ((Intent)localObject).putExtra("param_from", 20);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.c.d.getCurrentAccountUin());
      ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", this.c.a.b);
      ((Intent)localObject).putStringArrayListExtra("param_hide_filter_member_list", localArrayList);
      ((Intent)localObject).putExtra("param_pick_max_num", this.c.f);
      ((Intent)localObject).putExtra("param_pick_max_num_exceeds_wording", 2131895361);
      ((Intent)localObject).putExtra("param_pick_title_string", HardCodeUtil.a(2131899467));
      RouteUtils.a(this.c.getActivity(), (Intent)localObject, "/troop/memberlist/TroopMemberList", 1);
      this.c.getBaseActivity().overridePendingTransition(2130772434, 2130772007);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment.ListAdapter
 * JD-Core Version:    0.7.0.1
 */