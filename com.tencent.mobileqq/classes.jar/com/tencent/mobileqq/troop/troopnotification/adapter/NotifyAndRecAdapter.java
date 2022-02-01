package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter.ViewHolder;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfig;
import com.tencent.mobileqq.troop.troopnotification.systemmsginterface.BaseSystemMsgInterfaceForTroop;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NotifyAndRecAdapter
  extends XBaseAdapter
  implements SwipListView.SwipListListener
{
  private static HashMap<Long, MessageRecord> n = new HashMap();
  private static HashMap<Long, MessageRecord> o = new HashMap();
  private MqqHandler A;
  private View.OnClickListener B = new NotifyAndRecAdapter.2(this);
  private View.OnClickListener C = new NotifyAndRecAdapter.3(this);
  private View.OnClickListener D = new NotifyAndRecAdapter.4(this);
  protected List<MessageRecord> a = new ArrayList();
  protected List<RecommendTroopItem> b = new ArrayList();
  public List<MessageRecord> c = new ArrayList();
  public int d;
  AppInterface e;
  protected View f = null;
  TextView g;
  View h;
  public boolean i;
  public boolean j;
  protected boolean k;
  public boolean l;
  HashMap<String, String> m;
  private boolean p;
  private boolean q;
  private boolean r = false;
  private boolean s;
  private Context t;
  private AppRuntime u;
  private LayoutInflater v;
  private BaseSystemMsgInterfaceForTroop w;
  private boolean x;
  private DelMenuBuilder y;
  private int z = -1;
  
  public NotifyAndRecAdapter(AppRuntime paramAppRuntime, Context paramContext, MqqHandler paramMqqHandler, BaseSystemMsgInterfaceForTroop paramBaseSystemMsgInterfaceForTroop)
  {
    this.u = paramAppRuntime;
    this.e = ((AppInterface)paramAppRuntime);
    this.t = paramContext;
    this.v = LayoutInflater.from(paramContext);
    this.w = paramBaseSystemMsgInterfaceForTroop;
    this.x = false;
    this.A = paramMqqHandler;
    this.y = new DelMenuBuilder(paramContext);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.t)) {
      return;
    }
    if (!Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NotifyAndRecAdapter", 2, "handleDeleteItem|onClick tag is not int");
      }
      return;
    }
    Object localObject = paramView.getTag(-1);
    paramView = paramView.getTag(-2);
    if (((localObject instanceof Integer)) && ((paramView instanceof Integer)))
    {
      int i1 = ((Integer)localObject).intValue();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("handleDeleteItem|onClick position = ");
        paramView.append(i1);
        QLog.i("NotifyAndRecAdapter", 2, paramView.toString());
      }
      paramView = a(i1);
      if (!(paramView instanceof MessageRecord)) {
        return;
      }
      localObject = (MessageRecord)paramView;
      if (!(localObject instanceof MessageForSystemMsg)) {
        return;
      }
      paramView = ((MessageForSystemMsg)localObject).getSystemMsg();
      if (paramView == null) {
        return;
      }
      TroopNotifyHelper.a(paramView, ((MessageRecord)localObject).uniseq, AppConstants.TROOP_SYSTEM_MSG_UIN);
      localObject = this.A;
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(108);
      }
      TroopNotifyHelper.a(paramView, this.e, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyAndRecAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839579);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839577);
      return;
    }
    paramView.setBackgroundResource(2130839574);
  }
  
  private void a(RecommendTroopItem paramRecommendTroopItem)
  {
    if ((paramRecommendTroopItem != null) && (!TextUtils.isEmpty(paramRecommendTroopItem.uin)))
    {
      String str1 = paramRecommendTroopItem.uin;
      String str2 = paramRecommendTroopItem.name;
      paramRecommendTroopItem = paramRecommendTroopItem.recomAlgol;
      if (this.m == null) {
        this.m = new HashMap();
      }
      if (!this.m.containsKey(str1))
      {
        this.m.put(str1, paramRecommendTroopItem);
        TroopReportor.a("Grp_contacts_news", "notice", "recom_exp_grp", 0, 0, new String[] { str1, paramRecommendTroopItem });
        if (QLog.isColorLevel()) {
          QLog.d("TroopReportor.recommend", 2, String.format("notify reportTroopExposure, troopUin: %s, troopName: %s, recomAlgol:%s", new Object[] { str1, str2, paramRecommendTroopItem }));
        }
      }
      return;
    }
    QLog.e("TroopReportor.recommend", 1, "notify reportTroopExposure, troopUin == null or troopUin is empty!");
  }
  
  private int h()
  {
    this.r = false;
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    int i2 = localList.size();
    if (i2 == 0)
    {
      if (this.q)
      {
        this.r = true;
        this.p = true;
        return 2;
      }
      this.r = false;
      this.p = false;
      return 1;
    }
    localList = this.b;
    if (((localList == null) || (localList.size() == 0)) && (this.j))
    {
      this.i = true;
      return this.a.size();
    }
    if (this.x)
    {
      this.i = true;
      return this.a.size();
    }
    boolean bool = this.l;
    int i1 = 5;
    if ((!bool) || (i2 < 5)) {
      if (this.d >= 5) {
        this.l = true;
      } else if (i2 >= 3) {
        i1 = 3;
      } else {
        i1 = i2;
      }
    }
    if (i1 < i2)
    {
      this.p = true;
      return i1 + 1;
    }
    if (this.q)
    {
      this.r = true;
      this.p = true;
      return i2 + 1;
    }
    this.p = false;
    return i2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = a(paramInt);
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof NotifyAndRecAdapter.ViewHolder)))
    {
      paramViewGroup = (NotifyAndRecAdapter.ViewHolder)paramView.getTag();
      paramViewGroup.p.setPadding(ViewUtils.dip2px(5.0F), 0, ViewUtils.dip2px(5.0F), 0);
    }
    else
    {
      paramViewGroup = new NotifyAndRecAdapter.ViewHolder();
      paramView = this.y.a(this.t, 2131625945, paramViewGroup);
      localObject2 = new NotifyAndRecAdapter.ApplicantHolder();
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).a = paramView.findViewById(2131441347);
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).b = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject2).a.findViewById(2131441360));
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).d = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject2).a.findViewById(2131441361));
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).c = ((LinearLayout)((NotifyAndRecAdapter.ApplicantHolder)localObject2).a.findViewById(2131441357));
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).e = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject2).a.findViewById(2131441356));
      paramViewGroup.t = ((NotifyAndRecAdapter.ApplicantHolder)localObject2);
      paramViewGroup.g = ((LinearLayout)paramView.findViewById(2131441363));
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131441346));
      paramViewGroup.i = ((LinearLayout)paramView.findViewById(2131441354));
      paramViewGroup.k = ((ImageView)paramView.findViewById(2131441367));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131441352));
      paramViewGroup.l = ((TextView)paramView.findViewById(2131441364));
      paramViewGroup.m = ((TextView)paramView.findViewById(2131441366));
      paramViewGroup.n = ((TextView)paramView.findViewById(2131441353));
      paramViewGroup.p = ((Button)paramView.findViewById(2131441362));
      paramViewGroup.a = ((ShaderAnimLayout)paramView.findViewById(2131448064));
      paramView.setTag(paramViewGroup);
    }
    this.y.a(this.t, paramView, paramInt, localObject1, paramViewGroup, new NotifyAndRecAdapter.5(this), this.z);
    paramViewGroup.q = paramInt;
    localObject1 = (TroopNotificationConfig)QConfigManager.b().b(634);
    int i1;
    if ((localObject1 != null) && (((TroopNotificationConfig)localObject1).h == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt < this.d) && (i1 != 0)) {
      a(paramViewGroup.g, true);
    } else {
      a(paramViewGroup.g, false);
    }
    localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof MessageForSystemMsg)) {
        return paramView;
      }
      localObject2 = (MessageForSystemMsg)localObject1;
      paramViewGroup.r = ((MessageForSystemMsg)localObject2).getSystemMsg();
      paramViewGroup.s = ((MessageRecord)localObject1).uniseq;
      if (localObject1 != null) {
        i1 = ((MessageForSystemMsg)localObject2).getSystemMsg().msg_type.get();
      } else {
        i1 = 2;
      }
      if (i1 == 2) {
        this.w.a(paramViewGroup, paramInt);
      }
    }
    return paramView;
  }
  
  public MessageRecord a(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (MessageRecord)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    while (i1 < paramInt1)
    {
      if (getItemViewType(i1) == 0)
      {
        MessageRecord localMessageRecord = a(i1);
        if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForSystemMsg)))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg.msg_seq.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg.group_msg_type.has())) {
            if ((paramInt2 == 1) && (!n.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              n.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            } else if ((paramInt2 == 0) && (!o.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              o.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    if (ThemeUtil.isInNightMode(this.u)) {
      paramLinearLayout.setBackgroundResource(17170444);
    } else {
      paramLinearLayout.setBackgroundResource(17170443);
    }
    this.t.getResources();
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.dip2px(238.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dip2px(161.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180622/1bf451e30af44c7c8f49ef5dd5a25822.png", (URLDrawable.URLDrawableOptions)localObject);
    ((ImageView)paramLinearLayout.findViewById(2131434969)).setImageDrawable((Drawable)localObject);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)((Iterator)localObject).next();
        if (paramString.equals(localRecommendTroopItem.uin))
        {
          localRecommendTroopItem.hasRequestJoin = true;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateJoinStatus, troopUin: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("NotifyAndRecAdapter", 2, ((StringBuilder)localObject).toString());
          }
          notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    Object localObject;
    if ((QLog.isColorLevel()) && (paramList != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("noti size is ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("NotifyAndRecAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (paramList != null)
    {
      if (this.a == null) {
        return;
      }
      localObject = new HashSet();
      this.a.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!((Set)localObject).contains(Long.valueOf(localStructMsg.msg_seq.get()))))
          {
            ((Set)localObject).add(Long.valueOf(localStructMsg.msg_seq.get()));
            this.a.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.x;
  }
  
  public void b()
  {
    IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.e.getRuntimeService(IRecommendTroopService.class, "");
    if ((this.a != null) || (localIRecommendTroopService != null))
    {
      int i1 = 0;
      ArrayList localArrayList = new ArrayList(3);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MessageRecord)localIterator.next();
        if (i1 >= 3) {
          break;
        }
        if ((localObject instanceof MessageForSystemMsg))
        {
          localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
          oidb_0x935.NotifyInfo localNotifyInfo = new oidb_0x935.NotifyInfo();
          localNotifyInfo.uint64_notify_gc.set(((structmsg.StructMsg)localObject).msg.group_code.get());
          localNotifyInfo.uint32_notify_type.set(((structmsg.StructMsg)localObject).msg.group_msg_type.get());
          localArrayList.add(localNotifyInfo);
          i1 += 1;
        }
      }
      localIRecommendTroopService.saveGroupSysNotifyReportData(localArrayList);
    }
  }
  
  public void b(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRecData: ");
      localStringBuilder.append(paramList);
      QLog.d("NotifyAndRecAdapter", 2, localStringBuilder.toString());
    }
    this.b = paramList;
  }
  
  public void c()
  {
    List localList = this.a;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public boolean d()
  {
    List localList = this.b;
    return (localList != null) && (localList.size() > 0);
  }
  
  public void e()
  {
    Iterator localIterator = o.keySet().iterator();
    long l1;
    Object localObject;
    while (localIterator.hasNext())
    {
      l1 = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)o.get(Long.valueOf(l1));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          ReportController.b(this.u, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 2, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
    localIterator = n.keySet().iterator();
    while (localIterator.hasNext())
    {
      l1 = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)n.get(Long.valueOf(l1));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          ReportController.b(this.u, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 1, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
  }
  
  public int f()
  {
    if ((this.p) && (!this.x)) {
      return h() - 1;
    }
    return h();
  }
  
  public int g()
  {
    int i2 = this.b.size();
    int i1 = i2;
    if (this.s) {
      i1 = i2 + 1;
    }
    return i1;
  }
  
  public int getCount()
  {
    int i1 = h();
    int i2 = g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("total count is");
      localStringBuilder.append(i1);
      localStringBuilder.append(",");
      localStringBuilder.append(i2);
      QLog.d("NotifyAndRecAdapter", 2, localStringBuilder.toString());
    }
    return i1 + i2;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    List localList = this.a;
    if (localList == null) {
      return 3;
    }
    int i1 = localList.size();
    localList = this.b;
    if (((localList == null) || (localList.size() == 0)) && (this.j)) {
      this.i = true;
    } else {
      this.i = false;
    }
    if (i1 == 0)
    {
      if (paramInt == 0) {
        return 3;
      }
      if ((paramInt == h() - 1) && (this.p)) {
        return 2;
      }
    }
    if (this.i) {
      return 0;
    }
    i1 = h();
    if (paramInt == i1) {
      return 6;
    }
    int i2 = i1 - 1;
    if ((paramInt == i2) && (this.p)) {
      return 2;
    }
    if ((paramInt == i1 + 1) && (this.s)) {
      return 4;
    }
    if (paramInt <= i2) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    Object localObject1 = null;
    Object localObject2;
    if (i1 == 1)
    {
      i1 = paramInt - h() - 1;
      if ((i1 >= 0) && (i1 < this.b.size()))
      {
        localObject2 = (RecommendTroopItem)this.b.get(i1);
        AppInterface localAppInterface = this.e;
        if ((localAppInterface instanceof AppInterface)) {
          localObject1 = FaceDrawable.getFaceDrawable(localAppInterface, 4, ((RecommendTroopItem)localObject2).uin);
        }
        if ((paramView != null) && ((paramView.getTag() instanceof RecommendTroopAdapter.ViewHolder))) {
          break label131;
        }
        paramView = RecommendTroopAdapter.a(this.t, this.C, this.B, this.D);
        label131:
        RecommendTroopAdapter.a((RecommendTroopAdapter.ViewHolder)paramView.getTag(), (RecommendTroopItem)localObject2, (Drawable)localObject1);
        a((RecommendTroopItem)localObject2);
      }
      localObject1 = paramView;
    }
    else
    {
      if (i1 == 0) {
        localObject1 = a(paramInt, paramView, paramViewGroup);
      }
      for (;;)
      {
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        break label770;
        if (i1 == 2)
        {
          ReportController.b(this.u, "dc00899", "Grp_contacts_news", "", "notice", "verify_exp", 0, 0, "", "", "", "");
          localObject2 = LayoutInflater.from(this.t).inflate(2131629599, null);
          localObject1 = (TextView)((View)localObject2).findViewById(2131445494);
          if (!this.r) {
            if (this.d > h() - 2)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905458));
              ((StringBuilder)localObject1).append(this.d);
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905460));
              ((StringBuilder)localObject1).toString();
            }
            else
            {
              HardCodeUtil.a(2131905457);
            }
          }
          if (this.x) {
            ((View)localObject2).setVisibility(8);
          }
          ((View)localObject2).setOnClickListener(new NotifyAndRecAdapter.1(this, (View)localObject2));
          localObject1 = localObject2;
          if (!this.k)
          {
            TroopReportor.a("Grp_contacts_news", "notice", "verify_clk", 2, 0, new String[0]);
            this.k = true;
            localObject1 = localObject2;
          }
        }
        else if (i1 == 4)
        {
          i1 = this.t.getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0);
          this.f = LayoutInflater.from(this.t).inflate(2131626736, null);
          this.g = ((TextView)this.f.findViewById(2131439176));
          this.h = this.f.findViewById(2131439162);
          if (i1 != 0)
          {
            localObject1 = this.t.getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
            this.g.setText((CharSequence)localObject1);
          }
          else
          {
            this.h.setVisibility(8);
            this.f.setPadding(0, 0, 0, 0);
          }
          localObject1 = this.f;
        }
        else if (i1 == 5)
        {
          localObject1 = LayoutInflater.from(this.t).inflate(2131629600, null);
          ((TextView)((View)localObject1).findViewById(2131434982)).setText(HardCodeUtil.a(2131905456));
          ((LinearLayout)((View)localObject1).findViewById(2131439424)).setVisibility(8);
        }
        else if (i1 == 6)
        {
          localObject1 = LayoutInflater.from(this.t).inflate(2131629600, null);
          ((TextView)((View)localObject1).findViewById(2131434982)).setText(HardCodeUtil.a(2131905455));
          ((LinearLayout)((View)localObject1).findViewById(2131439424)).setVisibility(8);
        }
        else
        {
          if (i1 != 3) {
            break;
          }
          localObject1 = LayoutInflater.from(this.t).inflate(2131629600, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131434982);
          ((TextView)localObject2).setText(HardCodeUtil.a(2131905459));
          ((TextView)localObject2).setVisibility(8);
          localObject2 = (LinearLayout)((View)localObject1).findViewById(2131439424);
          ((LinearLayout)localObject2).setVisibility(0);
          a((LinearLayout)localObject2);
        }
      }
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    label770:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void updateCurShowRightView(View paramView)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i1 = i2;
      if ((paramView instanceof Integer)) {
        i1 = ((Integer)paramView).intValue();
      }
    }
    this.z = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter
 * JD-Core Version:    0.7.0.1
 */