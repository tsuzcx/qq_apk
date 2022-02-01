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
  private static HashMap<Long, MessageRecord> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<Long, MessageRecord> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NotifyAndRecAdapter.2(this);
  protected View a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DelMenuBuilder jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterDelMenuBuilder;
  private BaseSystemMsgInterfaceForTroop jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationSystemmsginterfaceBaseSystemMsgInterfaceForTroop;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  protected List<MessageRecord> a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new NotifyAndRecAdapter.3(this);
  View jdField_b_of_type_AndroidViewView;
  protected List<RecommendTroopItem> b;
  public boolean b;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new NotifyAndRecAdapter.4(this);
  public List<MessageRecord> c;
  protected boolean c;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g = false;
  private boolean h;
  private boolean i;
  
  public NotifyAndRecAdapter(AppRuntime paramAppRuntime, Context paramContext, MqqHandler paramMqqHandler, BaseSystemMsgInterfaceForTroop paramBaseSystemMsgInterfaceForTroop)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramAppRuntime);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationSystemmsginterfaceBaseSystemMsgInterfaceForTroop = paramBaseSystemMsgInterfaceForTroop;
    this.i = false;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterDelMenuBuilder = new DelMenuBuilder(paramContext);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
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
      int j = ((Integer)localObject).intValue();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("handleDeleteItem|onClick position = ");
        paramView.append(j);
        QLog.i("NotifyAndRecAdapter", 2, paramView.toString());
      }
      paramView = a(j);
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
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(108);
      }
      TroopNotifyHelper.a(paramView, this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
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
      paramView.setBackgroundResource(2130839395);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839393);
      return;
    }
    paramView.setBackgroundResource(2130839390);
  }
  
  private void a(RecommendTroopItem paramRecommendTroopItem)
  {
    if ((paramRecommendTroopItem != null) && (!TextUtils.isEmpty(paramRecommendTroopItem.uin)))
    {
      String str1 = paramRecommendTroopItem.uin;
      String str2 = paramRecommendTroopItem.name;
      paramRecommendTroopItem = paramRecommendTroopItem.recomAlgol;
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str1))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramRecommendTroopItem);
        TroopReportor.a("Grp_contacts_news", "notice", "recom_exp_grp", 0, 0, new String[] { str1, paramRecommendTroopItem });
        if (QLog.isColorLevel()) {
          QLog.d("TroopReportor.recommend", 2, String.format("notify reportTroopExposure, troopUin: %s, troopName: %s, recomAlgol:%s", new Object[] { str1, str2, paramRecommendTroopItem }));
        }
      }
      return;
    }
    QLog.e("TroopReportor.recommend", 1, "notify reportTroopExposure, troopUin == null or troopUin is empty!");
  }
  
  private int c()
  {
    this.g = false;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    int k = localList.size();
    if (k == 0)
    {
      if (this.f)
      {
        this.g = true;
        this.e = true;
        return 2;
      }
      this.g = false;
      this.e = false;
      return 1;
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    if (((localList == null) || (localList.size() == 0)) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    if (this.i)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    boolean bool = this.d;
    int j = 5;
    if ((!bool) || (k < 5)) {
      if (this.jdField_a_of_type_Int >= 5) {
        this.d = true;
      } else if (k >= 3) {
        j = 3;
      } else {
        j = k;
      }
    }
    if (j < k)
    {
      this.e = true;
      return j + 1;
    }
    if (this.f)
    {
      this.g = true;
      this.e = true;
      return k + 1;
    }
    this.e = false;
    return k;
  }
  
  public int a()
  {
    if ((this.e) && (!this.i)) {
      return c() - 1;
    }
    return c();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = a(paramInt);
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof NotifyAndRecAdapter.ViewHolder)))
    {
      paramViewGroup = (NotifyAndRecAdapter.ViewHolder)paramView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setPadding(ViewUtils.a(5.0F), 0, ViewUtils.a(5.0F), 0);
    }
    else
    {
      paramViewGroup = new NotifyAndRecAdapter.ViewHolder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterDelMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, 2131559902, paramViewGroup);
      localObject2 = new NotifyAndRecAdapter.ApplicantHolder();
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373673);
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131373686));
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131373687));
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131373683));
      ((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject2).jdField_a_of_type_AndroidViewView.findViewById(2131373682));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter$ApplicantHolder = ((NotifyAndRecAdapter.ApplicantHolder)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373689));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373672));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373680));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373693));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373678));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373690));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373692));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131373679));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373688));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131379327));
      paramView.setTag(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterDelMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, localObject1, paramViewGroup, new NotifyAndRecAdapter.5(this), this.jdField_b_of_type_Int);
    paramViewGroup.jdField_b_of_type_Int = paramInt;
    localObject1 = (TroopNotificationConfig)QConfigManager.a().a(634);
    int j;
    if ((localObject1 != null) && (((TroopNotificationConfig)localObject1).e == 1)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramInt < this.jdField_a_of_type_Int) && (j != 0)) {
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    } else {
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    }
    localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof MessageForSystemMsg)) {
        return paramView;
      }
      localObject2 = (MessageForSystemMsg)localObject1;
      paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localObject2).getSystemMsg();
      paramViewGroup.jdField_c_of_type_Long = ((MessageRecord)localObject1).uniseq;
      if (localObject1 != null) {
        j = ((MessageForSystemMsg)localObject2).getSystemMsg().msg_type.get();
      } else {
        j = 2;
      }
      if (j == 2) {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationSystemmsginterfaceBaseSystemMsgInterfaceForTroop.a(paramViewGroup, paramInt);
      }
    }
    return paramView;
  }
  
  public MessageRecord a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecommendTroopService.class, "");
    if ((this.jdField_a_of_type_JavaUtilList != null) || (localIRecommendTroopService != null))
    {
      int j = 0;
      ArrayList localArrayList = new ArrayList(3);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MessageRecord)localIterator.next();
        if (j >= 3) {
          break;
        }
        if ((localObject instanceof MessageForSystemMsg))
        {
          localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
          oidb_0x935.NotifyInfo localNotifyInfo = new oidb_0x935.NotifyInfo();
          localNotifyInfo.uint64_notify_gc.set(((structmsg.StructMsg)localObject).msg.group_code.get());
          localNotifyInfo.uint32_notify_type.set(((structmsg.StructMsg)localObject).msg.group_msg_type.get());
          localArrayList.add(localNotifyInfo);
          j += 1;
        }
      }
      localIRecommendTroopService.saveGroupSysNotifyReportData(localArrayList);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    while (j < paramInt1)
    {
      if (getItemViewType(j) == 0)
      {
        MessageRecord localMessageRecord = a(j);
        if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForSystemMsg)))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg.msg_seq.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg.group_msg_type.has())) {
            if ((paramInt2 == 1) && (!jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            } else if ((paramInt2 == 0) && (!jdField_c_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            }
          }
        }
      }
      j += 1;
    }
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) {
      paramLinearLayout.setBackgroundResource(17170444);
    } else {
      paramLinearLayout.setBackgroundResource(17170443);
    }
    this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ViewUtils.a(238.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.a(161.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180622/1bf451e30af44c7c8f49ef5dd5a25822.png", (URLDrawable.URLDrawableOptions)localObject);
    ((ImageView)paramLinearLayout.findViewById(2131368115)).setImageDrawable((Drawable)localObject);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
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
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilList.clear();
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
            this.jdField_a_of_type_JavaUtilList.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public int b()
  {
    int k = this.jdField_b_of_type_JavaUtilList.size();
    int j = k;
    if (this.h) {
      j = k + 1;
    }
    return j;
  }
  
  public void b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
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
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public boolean b()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    return (localList != null) && (localList.size() > 0);
  }
  
  public void c()
  {
    Iterator localIterator = jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
    long l;
    Object localObject;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 2, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
    localIterator = jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(l));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 1, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
  }
  
  public int getCount()
  {
    int j = c();
    int k = b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("total count is");
      localStringBuilder.append(j);
      localStringBuilder.append(",");
      localStringBuilder.append(k);
      QLog.d("NotifyAndRecAdapter", 2, localStringBuilder.toString());
    }
    return j + k;
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 3;
    }
    int j = localList.size();
    localList = this.jdField_b_of_type_JavaUtilList;
    if (((localList == null) || (localList.size() == 0)) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = true;
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    if (j == 0)
    {
      if (paramInt == 0) {
        return 3;
      }
      if ((paramInt == c() - 1) && (this.e)) {
        return 2;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    j = c();
    if (paramInt == j) {
      return 6;
    }
    int k = j - 1;
    if ((paramInt == k) && (this.e)) {
      return 2;
    }
    if ((paramInt == j + 1) && (this.h)) {
      return 4;
    }
    if (paramInt <= k) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    Object localObject1 = null;
    Object localObject2;
    if (j == 1)
    {
      j = paramInt - c() - 1;
      if ((j >= 0) && (j < this.jdField_b_of_type_JavaUtilList.size()))
      {
        localObject2 = (RecommendTroopItem)this.jdField_b_of_type_JavaUtilList.get(j);
        AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if ((localAppInterface instanceof AppInterface)) {
          localObject1 = FaceDrawable.getFaceDrawable(localAppInterface, 4, ((RecommendTroopItem)localObject2).uin);
        }
        if ((paramView != null) && ((paramView.getTag() instanceof RecommendTroopAdapter.ViewHolder))) {
          break label131;
        }
        paramView = RecommendTroopAdapter.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener);
        label131:
        RecommendTroopAdapter.a((RecommendTroopAdapter.ViewHolder)paramView.getTag(), (RecommendTroopItem)localObject2, (Drawable)localObject1);
        a((RecommendTroopItem)localObject2);
      }
      localObject1 = paramView;
    }
    else
    {
      if (j == 0) {
        localObject1 = a(paramInt, paramView, paramViewGroup);
      }
      for (;;)
      {
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        break label766;
        if (j == 2)
        {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "verify_exp", 0, 0, "", "", "", "");
          localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562991, null);
          localObject1 = (TextView)((View)localObject2).findViewById(2131377123);
          if (!this.g) {
            if (this.jdField_a_of_type_Int > c() - 2)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707643));
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707645));
              ((StringBuilder)localObject1).toString();
            }
            else
            {
              HardCodeUtil.a(2131707642);
            }
          }
          if (this.i) {
            ((View)localObject2).setVisibility(8);
          }
          ((View)localObject2).setOnClickListener(new NotifyAndRecAdapter.1(this, (View)localObject2));
          localObject1 = localObject2;
          if (!this.jdField_c_of_type_Boolean)
          {
            TroopReportor.a("Grp_contacts_news", "notice", "verify_clk", 2, 0, new String[0]);
            this.jdField_c_of_type_Boolean = true;
            localObject1 = localObject2;
          }
        }
        else if (j == 4)
        {
          j = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0);
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560691, null);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371745));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371731);
          if (j != 0)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          }
          else
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
          }
          localObject1 = this.jdField_a_of_type_AndroidViewView;
        }
        else if (j == 5)
        {
          localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562992, null);
          ((TextView)((View)localObject1).findViewById(2131368127)).setText(HardCodeUtil.a(2131707641));
          ((LinearLayout)((View)localObject1).findViewById(2131371979)).setVisibility(8);
        }
        else if (j == 6)
        {
          localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562992, null);
          ((TextView)((View)localObject1).findViewById(2131368127)).setText(HardCodeUtil.a(2131707640));
          ((LinearLayout)((View)localObject1).findViewById(2131371979)).setVisibility(8);
        }
        else
        {
          if (j != 3) {
            break;
          }
          localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562992, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131368127);
          ((TextView)localObject2).setText(HardCodeUtil.a(2131707644));
          ((TextView)localObject2).setVisibility(8);
          localObject2 = (LinearLayout)((View)localObject1).findViewById(2131371979);
          ((LinearLayout)localObject2).setVisibility(0);
          a((LinearLayout)localObject2);
        }
      }
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    label766:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void updateCurShowRightView(View paramView)
  {
    int k = -1;
    int j = k;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      j = k;
      if ((paramView instanceof Integer)) {
        j = ((Integer)paramView).intValue();
      }
    }
    this.jdField_b_of_type_Int = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter
 * JD-Core Version:    0.7.0.1
 */