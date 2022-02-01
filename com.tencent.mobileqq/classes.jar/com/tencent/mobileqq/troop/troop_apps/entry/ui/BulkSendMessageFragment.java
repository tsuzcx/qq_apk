package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.UIUtils.StoryProgressUI;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.homework.IHomeworkHandler;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
import tencent.im.troop.homework.ReqSend1V1Msg;

public class BulkSendMessageFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, SoftKeyboardObserver.OnSoftKeyboardToggledListener, DecodeTaskCompletionListener
{
  protected BulkSendMessageFragment.ListAdapter a = new BulkSendMessageFragment.ListAdapter(this);
  protected List<String> b = new ArrayList();
  protected String c = "";
  protected QQAppInterface d;
  protected IFaceDecoder e;
  protected int f = 10;
  protected MyGridView g;
  protected ClearableEditText h;
  protected Button i;
  protected View j;
  protected TextView k;
  protected TextView l;
  protected UIUtils.StoryProgressUI m;
  public SoftKeyboardObserver n;
  public View o;
  public Handler p;
  public Runnable q = new BulkSendMessageFragment.1(this);
  private HomeworkObserver r = new BulkSendMessageFragment.2(this);
  
  private void a()
  {
    this.h = ((ClearableEditText)this.mContentView.findViewById(2131432352));
    this.h.setClearButtonStyle(1);
    Object localObject = this.h.getLayoutParams();
    this.h.setSingleLine(false);
    this.h.setFilters(new InputFilter[] { new InputFilter.LengthFilter(300) });
    int i1 = this.h.getText().length();
    this.h.setSelection(i1, i1);
    this.h.setGravity(48);
    this.h.addTextChangedListener(this);
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = ((int)(this.mDensity * 150.0F));
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.h.setHint(HardCodeUtil.a(2131899472));
    this.h.setOnTouchListener(new BulkSendMessageFragment.3(this));
    this.mContentView.setOnTouchListener(new BulkSendMessageFragment.4(this));
    this.j = this.mContentView.findViewById(2131429874);
    this.j.setOnClickListener(this);
    this.k = ((TextView)this.mContentView.findViewById(2131448933));
    this.g = ((MyGridView)this.mContentView.findViewById(2131449239));
    this.g.setAdapter(this.a);
    this.i = ((Button)this.mContentView.findViewById(2131430010));
    this.i.setText(HardCodeUtil.a(2131899480));
    this.i.setOnClickListener(this);
    this.i.setEnabled(false);
    this.o = this.mContentView.findViewById(2131436998);
    this.mContentView.findViewById(2131430014).setOnClickListener(this);
    this.l = ((TextView)this.mContentView.findViewById(2131448942));
    if (this.b.size() == 0) {
      this.mContentView.findViewById(2131445899).setVisibility(8);
    } else {
      this.mContentView.findViewById(2131445899).setOnClickListener(new BulkSendMessageFragment.5(this));
    }
    setTitle(HardCodeUtil.a(2131899466));
    c();
    b();
    localObject = TroopReportor.a(this.d, this.c);
    TroopReportor.a("Grp_edu", "MassMessage", "CreateMessage_Show", 0, 0, new String[] { this.c, localObject });
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.a(paramActivity, localIntent, BulkSendMessageFragment.class);
    paramActivity.overridePendingTransition(2130772434, 2130772007);
  }
  
  private void b()
  {
    int i1 = this.h.getText().length();
    ColorStateList localColorStateList;
    if (i1 > 300) {
      localColorStateList = getResources().getColorStateList(2131168185);
    } else {
      localColorStateList = getResources().getColorStateList(2131168125);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(300);
    localObject = ((StringBuilder)localObject).toString();
    if (localColorStateList != null) {
      this.l.setTextColor(localColorStateList);
    }
    this.l.setText((CharSequence)localObject);
  }
  
  private void c()
  {
    int i2 = this.h.length();
    int i3 = this.a.b.size();
    boolean bool2 = true;
    int i1;
    if (i3 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1;
    if ((i2 >= 1) && (i2 <= 300) && (i1 != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (i3 > 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    Object localObject = String.format(Locale.getDefault(), "（%d个）", new Object[] { Integer.valueOf(i3) });
    this.k.setText((CharSequence)localObject);
    localObject = this.k;
    i3 = 8;
    if (i2 != 0) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((TextView)localObject).setVisibility(i2);
    this.i.setEnabled(bool1);
    this.i.setClickable(bool1);
    localObject = this.j;
    i2 = i3;
    if (i1 != 0) {
      i2 = 0;
    }
    ((View)localObject).setVisibility(i2);
    localObject = this.a;
    if (((BulkSendMessageFragment.ListAdapter)localObject).b.size() < this.f) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((BulkSendMessageFragment.ListAdapter)localObject).a = bool1;
    this.a.notifyDataSetChanged();
  }
  
  private void d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((ActionSheet)localObject).addButton((String)localIterator.next());
      }
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnButtonClickListener(new BulkSendMessageFragment.6(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  protected void a(BulkSendMessageFragment.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.a == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.e.getBitmapFromCacheFrom(3, paramViewHolder.c, 5);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = ImageUtil.k();
      }
      paramBitmap = localBitmap;
      if (!this.e.isPausing())
      {
        this.e.requestDecodeFace(paramViewHolder.c, 3, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.a.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.p.removeCallbacks(this.q);
      this.o.setVisibility(8);
      return;
    }
    this.p.postDelayed(this.q, 10L);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
    b();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = getBaseActivity().getIntent().getStringExtra("extra.GROUP_UIN");
    this.d = QQStoryContext.j();
    this.e = ((IQQAvatarService)this.d.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.d);
    this.e.setDecodeTaskCompletionListener(this);
    this.p = new Handler();
    paramLayoutInflater = ((ITroopAppService)this.d.getRuntimeService(ITroopAppService.class, "all")).getAppConfig("BulkChatMessageConfig");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "ReadConfig: ", String.valueOf(paramLayoutInflater) });
    }
    if (paramLayoutInflater != null)
    {
      this.f = paramLayoutInflater.optInt("user_limit", this.f);
      paramLayoutInflater.optJSONArray("hints");
    }
    a();
    this.d.addObserver(this.r);
    this.n = new SoftKeyboardObserver(this.mContentView, this, ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + 160);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626665;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringArrayListExtra("extra_member_uin_list");
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = paramIntent.iterator();
          while (((Iterator)localObject).hasNext()) {
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", (String)((Iterator)localObject).next() });
          }
        }
        paramInt2 = this.a.b.size() - paramIntent.size();
        if ((paramInt1 == 2) && (paramInt2 != 0))
        {
          localObject = TroopReportor.a(this.d, this.c);
          TroopReportor.a("Grp_edu", "MassMessage", "MemberEdit_Complete", 0, 0, new String[] { this.c, localObject, String.valueOf(paramInt2) });
        }
        this.a.b = new ArrayList(paramIntent);
        this.a.notifyDataSetChanged();
        c();
        return;
      }
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_app.BulkSendMessageFragment", 1, new Object[] { "SelectMember canceled! requestCode: ", Integer.valueOf(paramInt1), new NullPointerException() });
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Error! SelectMember return null! requestCode: ");
        paramIntent.append(paramInt1);
        QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, paramIntent.toString(), new NullPointerException());
      }
    }
    else if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if (QLog.isColorLevel()) {
        paramIntent = paramIntent.iterator();
      }
    }
    else
    {
      while (paramIntent.hasNext())
      {
        QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", ((ResultRecord)paramIntent.next()).uin });
        continue;
        QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null!", new NullPointerException());
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    getBaseActivity().overridePendingTransition(0, 2130772018);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429874)
    {
      if (i1 != 2131430010)
      {
        if (i1 != 2131430014) {
          break label607;
        }
        if (this.h.length() == 0)
        {
          QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131899470), new Object[0]), 1).show();
          break label607;
        }
        if (this.h.length() < 4)
        {
          QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131899468), new Object[] { Integer.valueOf(4) }), 1).show();
          break label607;
        }
        if (!this.a.b.isEmpty()) {
          break label607;
        }
        QQToast.makeText(getBaseActivity(), 1, String.format(Locale.getDefault(), HardCodeUtil.a(2131899476), new Object[0]), 1).show();
        break label607;
      }
      localObject = this.h.getText().toString();
      if (((String)localObject).length() < 4)
      {
        localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131899471), new Object[] { Integer.valueOf(4) });
        QQToast.makeText(getBaseActivity(), 1, (CharSequence)localObject, 1).show();
        break label607;
      }
      if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
      {
        localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131899475), new Object[0]);
        QQToast.makeText(getBaseActivity(), 1, (CharSequence)localObject, 1).show();
        break label607;
      }
    }
    try
    {
      homework.ReqSend1V1Msg localReqSend1V1Msg = new homework.ReqSend1V1Msg();
      i1 = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localReqSend1V1Msg.to_uins.add(Long.valueOf(Long.parseLong(str)));
      }
      localReqSend1V1Msg.text.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqSend1V1Msg.int32_time_zone.set(i1);
      localReqSend1V1Msg.group_id.set(Long.parseLong(this.c));
      if (this.m != null)
      {
        this.m.a();
        this.m = null;
      }
      this.m = UIUtils.a(getBaseActivity(), HardCodeUtil.a(2131899479));
      ((IHomeworkHandler)this.d.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName())).a(localReqSend1V1Msg);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label449:
      break label449;
    }
    Object localObject = HardCodeUtil.a(2131899478);
    QQToast.makeText(getBaseActivity(), 1, (CharSequence)localObject, 1).show();
    break label607;
    localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.c);
    ((Intent)localObject).putExtra("param_from", 21);
    ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", this.a.b);
    ((Intent)localObject).putStringArrayListExtra("param_delete_filter_member_list", this.a.b);
    ((Intent)localObject).putExtra("param_pick_max_num", this.f);
    ((Intent)localObject).putExtra("param_pick_title_string", HardCodeUtil.a(2131899477));
    RouteUtils.a(getActivity(), (Intent)localObject, "/troop/memberlist/TroopMemberList", 2);
    getBaseActivity().overridePendingTransition(2130772434, 2130772007);
    TroopReportor.a("Grp_edu", "MassMessage", "Member_Edit", 0, 0, new String[] { this.c });
    label607:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.g.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.g.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof BulkSendMessageFragment.ViewHolder)))
        {
          localObject = (BulkSendMessageFragment.ViewHolder)localObject;
          if (paramString == null)
          {
            a((BulkSendMessageFragment.ViewHolder)localObject, null, false);
          }
          else if (paramString.equals(((BulkSendMessageFragment.ViewHolder)localObject).c))
          {
            ((BulkSendMessageFragment.ViewHolder)localObject).a.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.d.removeObserver(this.r);
    this.e.setDecodeTaskCompletionListener(null);
    this.h.removeTextChangedListener(this);
    this.n.a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment
 * JD-Core Version:    0.7.0.1
 */