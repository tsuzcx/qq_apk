package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.InputMethodChangeListener;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.troop.homework.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubmitHomeWorkFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, InputMethodGuard.InputMethodChangeListener
{
  protected static String a;
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  protected ViewGroup a;
  protected AppInterface a;
  protected CommonRecordSoundPanel a;
  protected HomeworkInfo a;
  protected SubmitHomeWorkFragment.UIHandler a;
  protected InputMethodGuard a;
  protected HomeworkHandler a;
  protected HomeworkObserver a;
  protected XMediaEditor a;
  protected QQProgressDialog a;
  protected ActionSheet a;
  protected LinkedList<JSONObject> a;
  protected boolean a;
  protected long b;
  protected HomeworkInfo b;
  protected XMediaEditor b;
  protected String b;
  protected long c;
  protected View c;
  protected String c;
  protected boolean c;
  protected View d;
  protected String d;
  protected boolean d;
  protected View e;
  protected boolean e;
  
  public SubmitHomeWorkFragment()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new SubmitHomeWorkFragment.10(this);
  }
  
  public static Intent a(Activity paramActivity, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("SubmitHomeWorkFragment:valid", "SubmitHomeWorkFragment:valid");
    localIntent.putExtra("HomeWorkConstants:homework_id_default_request_key", paramLong2);
    localIntent.putExtra("extra.GROUP_UIN", String.valueOf(paramLong1));
    localIntent.putExtra("public_fragment_class", SubmitHomeWorkFragment.class.getName());
    localIntent.setClass(paramActivity, QPublicFragmentActivity.class);
    return localIntent;
  }
  
  public static void a(Activity paramActivity)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(paramActivity);
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putLong("HomeWorkConstants:homework_id_default_request_key", paramLong2);
    localBundle.putString("SubmitHomeWorkFragment:valid", "SubmitHomeWorkFragment:valid");
    if (paramLong1 > 0L) {
      localBundle.putString("extra.GROUP_UIN", String.valueOf(paramLong1));
    }
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.start(paramActivity, localIntent, SubmitHomeWorkFragment.class);
  }
  
  protected int a()
  {
    return 2131560666;
  }
  
  protected <T extends View> T a(int paramInt)
  {
    return this.jdField_b_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  protected EditText a(View paramView)
  {
    EditText localEditText = null;
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      int i = 0;
      paramView = localEditText;
      while (i < j)
      {
        localEditText = a(localViewGroup.getChildAt(i));
        if (localEditText != null) {
          paramView = localEditText;
        }
        i += 1;
      }
      return paramView;
    }
    if (((paramView instanceof EditText)) && (paramView.isFocused())) {
      return (EditText)paramView;
    }
    return null;
  }
  
  @NonNull
  protected List<String> a(UploadEditItemInfo paramUploadEditItemInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramUploadEditItemInfo != null)
    {
      if ((paramUploadEditItemInfo instanceof VideoInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131714436));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof ImageInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131714429));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof AudioInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131714423));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
      }
    }
    return localArrayList;
  }
  
  /* Error */
  List<Boolean> a(@NonNull JSONArray paramJSONArray1, @NonNull JSONArray paramJSONArray2)
  {
    // Byte code:
    //   0: new 194	java/util/ArrayList
    //   3: dup
    //   4: iconst_3
    //   5: invokespecial 231	java/util/ArrayList:<init>	(I)V
    //   8: astore 13
    //   10: new 233	org/json/JSONArray
    //   13: dup
    //   14: aload_0
    //   15: getfield 235	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor	Lcom/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor;
    //   18: invokevirtual 239	com/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor:a	()Ljava/lang/String;
    //   21: invokespecial 242	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   24: astore 15
    //   26: new 233	org/json/JSONArray
    //   29: dup
    //   30: aload_0
    //   31: getfield 244	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor	Lcom/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor;
    //   34: invokevirtual 239	com/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor:a	()Ljava/lang/String;
    //   37: invokespecial 242	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   40: astore 14
    //   42: aload 15
    //   44: invokevirtual 247	org/json/JSONArray:length	()I
    //   47: istore 4
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: iload 4
    //   54: if_icmpge +30 -> 84
    //   57: aload 15
    //   59: iload_3
    //   60: invokevirtual 251	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   63: astore 16
    //   65: aload_0
    //   66: aload 16
    //   68: invokevirtual 254	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Lorg/json/JSONObject;)Z
    //   71: ifeq +336 -> 407
    //   74: aload_1
    //   75: aload 16
    //   77: invokevirtual 258	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   80: pop
    //   81: goto +326 -> 407
    //   84: aload 14
    //   86: invokevirtual 247	org/json/JSONArray:length	()I
    //   89: istore 4
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: iload 4
    //   96: if_icmpge +30 -> 126
    //   99: aload 14
    //   101: iload_3
    //   102: invokevirtual 251	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   105: astore 15
    //   107: aload_0
    //   108: aload 15
    //   110: invokevirtual 254	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Lorg/json/JSONObject;)Z
    //   113: ifeq +301 -> 414
    //   116: aload_2
    //   117: aload 15
    //   119: invokevirtual 258	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   122: pop
    //   123: goto +291 -> 414
    //   126: aload_0
    //   127: getfield 260	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   130: invokevirtual 265	java/util/LinkedList:isEmpty	()Z
    //   133: istore 5
    //   135: iload 5
    //   137: ifne +9 -> 146
    //   140: iconst_1
    //   141: istore 5
    //   143: goto +6 -> 149
    //   146: iconst_0
    //   147: istore 5
    //   149: aload_0
    //   150: getfield 260	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   153: invokevirtual 265	java/util/LinkedList:isEmpty	()Z
    //   156: ifne +32 -> 188
    //   159: aload_0
    //   160: getfield 244	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor	Lcom/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor;
    //   163: invokevirtual 239	com/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor:a	()Ljava/lang/String;
    //   166: aload_0
    //   167: getfield 48	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokevirtual 268	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: istore 6
    //   175: iload 6
    //   177: iconst_1
    //   178: ixor
    //   179: istore 7
    //   181: iload 7
    //   183: istore 6
    //   185: goto +9 -> 194
    //   188: iconst_0
    //   189: istore 7
    //   191: iconst_0
    //   192: istore 6
    //   194: aload_1
    //   195: invokevirtual 247	org/json/JSONArray:length	()I
    //   198: istore_3
    //   199: iload_3
    //   200: ifle +9 -> 209
    //   203: iconst_1
    //   204: istore 8
    //   206: goto +6 -> 212
    //   209: iconst_0
    //   210: istore 8
    //   212: iload 7
    //   214: istore 9
    //   216: iload 6
    //   218: istore 10
    //   220: iload 8
    //   222: istore 11
    //   224: iload 5
    //   226: istore 12
    //   228: iload 7
    //   230: ifne +122 -> 352
    //   233: aload_1
    //   234: invokevirtual 247	org/json/JSONArray:length	()I
    //   237: istore_3
    //   238: iload_3
    //   239: ifle +21 -> 260
    //   242: iconst_1
    //   243: istore 9
    //   245: iload 6
    //   247: istore 10
    //   249: iload 8
    //   251: istore 11
    //   253: iload 5
    //   255: istore 12
    //   257: goto +95 -> 352
    //   260: iconst_0
    //   261: istore 9
    //   263: iload 6
    //   265: istore 10
    //   267: iload 8
    //   269: istore 11
    //   271: iload 5
    //   273: istore 12
    //   275: goto +77 -> 352
    //   278: astore_1
    //   279: goto +24 -> 303
    //   282: astore_1
    //   283: goto +17 -> 300
    //   286: astore_1
    //   287: goto +7 -> 294
    //   290: astore_1
    //   291: iconst_0
    //   292: istore 5
    //   294: iconst_0
    //   295: istore 7
    //   297: iconst_0
    //   298: istore 6
    //   300: iconst_0
    //   301: istore 8
    //   303: iload 7
    //   305: istore 9
    //   307: iload 6
    //   309: istore 10
    //   311: iload 8
    //   313: istore 11
    //   315: iload 5
    //   317: istore 12
    //   319: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +30 -> 352
    //   325: ldc_w 275
    //   328: iconst_2
    //   329: ldc_w 277
    //   332: aload_1
    //   333: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   336: iload 5
    //   338: istore 12
    //   340: iload 8
    //   342: istore 11
    //   344: iload 6
    //   346: istore 10
    //   348: iload 7
    //   350: istore 9
    //   352: aload 13
    //   354: iload 9
    //   356: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   359: invokeinterface 288 2 0
    //   364: pop
    //   365: aload 13
    //   367: iload 10
    //   369: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   372: invokeinterface 288 2 0
    //   377: pop
    //   378: aload 13
    //   380: iload 11
    //   382: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   385: invokeinterface 288 2 0
    //   390: pop
    //   391: aload 13
    //   393: iload 12
    //   395: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: invokeinterface 288 2 0
    //   403: pop
    //   404: aload 13
    //   406: areturn
    //   407: iload_3
    //   408: iconst_1
    //   409: iadd
    //   410: istore_3
    //   411: goto -360 -> 51
    //   414: iload_3
    //   415: iconst_1
    //   416: iadd
    //   417: istore_3
    //   418: goto -325 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	SubmitHomeWorkFragment
    //   0	421	1	paramJSONArray1	JSONArray
    //   0	421	2	paramJSONArray2	JSONArray
    //   50	368	3	i	int
    //   47	50	4	j	int
    //   133	204	5	bool1	boolean
    //   173	172	6	bool2	boolean
    //   179	170	7	bool3	boolean
    //   204	137	8	bool4	boolean
    //   214	141	9	bool5	boolean
    //   218	150	10	bool6	boolean
    //   222	159	11	bool7	boolean
    //   226	168	12	bool8	boolean
    //   8	397	13	localArrayList	ArrayList
    //   40	60	14	localJSONArray	JSONArray
    //   24	94	15	localObject	Object
    //   63	13	16	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   233	238	278	java/lang/Exception
    //   194	199	282	java/lang/Exception
    //   149	175	286	java/lang/Exception
    //   10	49	290	java/lang/Exception
    //   57	81	290	java/lang/Exception
    //   84	91	290	java/lang/Exception
    //   99	123	290	java/lang/Exception
    //   126	135	290	java/lang/Exception
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$UIHandler = new SubmitHomeWorkFragment.UIHandler(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    if (getActivity() == null) {
      localObject = null;
    } else {
      localObject = (AppInterface)getQBaseActivity().getAppRuntime();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject);
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject == null)
    {
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler = ((HomeworkHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName()));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver = new SubmitHomeWorkFragment.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver);
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    }
  }
  
  protected void a(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
    }
    ArrayList localArrayList = ((XMediaEditor)localObject1).a(paramInt);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = localArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditItemInfoBase)((Iterator)localObject1).next();
      if (localObject2 != null) {
        localJSONArray.put(((EditItemInfoBase)localObject2).a());
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject1, "", String.valueOf(localArrayList.size()), localJSONArray.toString() });
    }
  }
  
  protected void a(int paramInt, ArrayList<UploadEditItemInfo> paramArrayList1, ArrayList<UploadEditItemInfo> paramArrayList2, HomeworkInfo paramHomeworkInfo)
  {
    if (paramInt == 0)
    {
      paramHomeworkInfo = new ArrayList();
      Object localObject = paramArrayList1.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramHomeworkInfo.addAll(a((UploadEditItemInfo)((Iterator)localObject).next()));
      }
      localObject = paramArrayList2.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramHomeworkInfo.addAll(a((UploadEditItemInfo)((Iterator)localObject).next()));
      }
      paramHomeworkInfo = new ArrayList(new TreeSet(paramHomeworkInfo));
      if (paramHomeworkInfo.isEmpty())
      {
        paramHomeworkInfo = "";
      }
      else if (paramHomeworkInfo.size() == 1)
      {
        paramHomeworkInfo = (String)paramHomeworkInfo.get(0);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramHomeworkInfo.get(0));
        ((StringBuilder)localObject).append("、");
        ((StringBuilder)localObject).append((String)paramHomeworkInfo.get(1));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131714425));
        paramHomeworkInfo = ((StringBuilder)localObject).toString();
      }
      int i = this.jdField_a_of_type_Int;
      if (i == 0)
      {
        this.jdField_a_of_type_Int = (i + 1);
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList1.isEmpty())) {
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList1);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList2.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList2);
        }
        paramArrayList1 = getString(2131697500, new Object[] { paramHomeworkInfo });
        QQToast.a(getActivity(), paramArrayList1, 0).a();
      }
      else
      {
        paramArrayList1 = getString(2131697498, new Object[] { paramHomeworkInfo });
        QQToast.a(getActivity(), paramArrayList1, 0).a();
      }
    }
    else if (paramInt == 1)
    {
      QQToast.a(getActivity(), 2131697469, 0).a();
    }
    else if (paramInt == 3)
    {
      QQToast.a(getActivity(), 2131697494, 0).a();
    }
    else if (paramInt == 2)
    {
      QQToast.a(getActivity(), 2131694431, 0).a();
    }
    if (QLog.isColorLevel())
    {
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append("Error, reason_code = ");
      paramArrayList1.append(paramInt);
      paramArrayList1.append(", print trace: ");
      QLog.d("SubmitHomeWorkFragment", 2, paramArrayList1.toString(), new RuntimeException("UPLOAD_ERROR"));
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    a();
    c();
    d();
    e();
    if (MobileQQ.sProcessId != 9) {
      a(getActivity());
    }
  }
  
  protected void a(HomeworkInfo paramHomeworkInfo)
  {
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = localArrayList1;
    if (localArrayList1 == null) {
      localObject2 = new ArrayList();
    }
    if ((((ArrayList)localObject1).isEmpty()) && (((ArrayList)localObject2).isEmpty()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler != null) && (paramHomeworkInfo != null))
      {
        a(2131697460);
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = paramHomeworkInfo;
        this.jdField_b_of_type_Long = paramHomeworkInfo.jdField_d_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler.a(paramHomeworkInfo.jdField_d_of_type_Long, paramHomeworkInfo.jdField_a_of_type_Long, paramHomeworkInfo.jdField_b_of_type_JavaLangString);
        return;
      }
      a(3, null, null, paramHomeworkInfo);
      return;
    }
    localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      UploadEditItemInfo localUploadEditItemInfo = (UploadEditItemInfo)((Iterator)localObject1).next();
      if (localUploadEditItemInfo != null) {
        if (localUploadEditItemInfo.c() == 1) {
          localArrayList3.add(localUploadEditItemInfo);
        } else if ((localUploadEditItemInfo.c() == 2) || (localUploadEditItemInfo.c() == 0)) {
          localArrayList1.add(localUploadEditItemInfo);
        }
      }
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UploadEditItemInfo)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((UploadEditItemInfo)localObject2).c() == 1) {
          localArrayList3.add(localObject2);
        } else if ((((UploadEditItemInfo)localObject2).c() == 2) || (((UploadEditItemInfo)localObject2).c() == 0)) {
          localArrayList2.add(localObject2);
        }
      }
    }
    if (!localArrayList3.isEmpty())
    {
      a(localArrayList3);
      return;
    }
    if ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))
    {
      a(3, null, null, paramHomeworkInfo);
      return;
    }
    a(0, localArrayList1, localArrayList2, paramHomeworkInfo);
  }
  
  protected void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        boolean bool = paramString.has("c");
        i = 0;
        if (bool)
        {
          paramString = paramString.getJSONArray("c");
          if (paramString != null)
          {
            this.jdField_b_of_type_JavaLangString = paramString.toString();
            if (i < paramString.length())
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              if (localJSONObject == null) {
                break label183;
              }
              String str = localJSONObject.getString("type");
              if (!TextUtils.isEmpty(str))
              {
                if (!Arrays.asList(HomeWorkConstants.c).contains(str)) {
                  break label183;
                }
                this.jdField_a_of_type_JavaUtilLinkedList.add(localJSONObject);
                break label183;
              }
              if (!QLog.isColorLevel()) {
                break label183;
              }
              QLog.d("SubmitHomeWorkFragment", 2, "home work must contains type key");
              break label183;
            }
          }
          f();
          return;
        }
        paramString = new IllegalArgumentException("home work json format error");
        if (QLog.isColorLevel())
        {
          QLog.e("SubmitHomeWorkFragment", 2, paramString, new Object[0]);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SubmitHomeWorkFragment", 2, "parse homework json error", paramString);
        }
      }
      return;
      label183:
      i += 1;
    }
  }
  
  protected void a(@NonNull ArrayList<UploadEditItemInfo> paramArrayList)
  {
    Object localObject = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((List)localObject).addAll(a((UploadEditItemInfo)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet((Collection)localObject));
    if (paramArrayList.isEmpty())
    {
      paramArrayList = "";
    }
    else if (paramArrayList.size() == 1)
    {
      paramArrayList = (String)paramArrayList.get(0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)paramArrayList.get(0));
      ((StringBuilder)localObject).append("、");
      ((StringBuilder)localObject).append((String)paramArrayList.get(1));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131714434));
      paramArrayList = ((StringBuilder)localObject).toString();
    }
    paramArrayList = getString(2131697500, new Object[] { paramArrayList });
    QQToast.a(getActivity(), paramArrayList, 0).a();
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    String str = paramJSONObject.optString("type");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return (!"str".equals(str)) || (!TextUtils.isEmpty(paramJSONObject.optString("text")));
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2);
    if (i >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131714435));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131714433));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - i, getActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivity(paramView);
    InputMethodUtil.a(getActivity());
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detect input method state changed, current state is ");
      String str;
      if (paramBoolean) {
        str = "on";
      } else {
        str = "off";
      }
      localStringBuilder.append(str);
      QLog.d("SubmitHomeWorkFragment", 2, localStringBuilder.toString());
    }
    c(paramBoolean);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = a(2131378067);
    this.jdField_d_of_type_AndroidViewView = a(2131363773);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368896));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131368325));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560665, null, false));
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368331));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(DisplayUtil.a(getActivity(), 12.0F));
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(DisplayUtil.a(getActivity(), 12.0F));
    this.jdField_e_of_type_AndroidViewView = a(2131371490);
    e(this.jdField_e_of_type_AndroidViewView.findViewById(2131371491));
    this.jdField_e_of_type_AndroidViewView.findViewById(2131371491).setOnClickListener(this);
    View localView = a(2131373255);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localView = a(2131373262);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localView = a(2131373263);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131714437));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131714428));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    jdField_a_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onVideoBtnClick", String.format("mCameraPath=%s", new Object[] { jdField_a_of_type_JavaLangString }) });
    }
    InputMethodUtil.a(getActivity());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void d()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      String str2 = localBundle.getString("extra.GROUP_UIN");
      String str1;
      if (str2 == null) {
        str1 = "";
      } else {
        str1 = str2;
      }
      TroopReportor.a("Grp_edu", "homework", "CompleteHw_Show", 0, 0, new String[] { str1 });
      if (!TextUtils.isEmpty(str2))
      {
        this.jdField_d_of_type_JavaLangString = str2;
        this.jdField_a_of_type_Long = localBundle.getLong("HomeWorkConstants:homework_id_default_request_key");
        if (this.jdField_a_of_type_Long > 0L)
        {
          a(2131697449);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler.a(this.jdField_a_of_type_Long);
          return;
        }
        QQToast.a(getActivity(), 2131697496, 0).a();
        getActivity().finish();
        return;
      }
      QQToast.a(getActivity(), 2131697496, 0).a();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131697496, 0).a();
    getActivity().finish();
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131714430));
        localStringBuilder.append(6);
        localStringBuilder.append(HardCodeUtil.a(2131714424));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    InputMethodUtil.b(paramView);
    i();
  }
  
  protected void e()
  {
    a(2131697484, new SubmitHomeWorkFragment.2(this));
    c(2131697492, new SubmitHomeWorkFragment.3(this));
    a(getResources().getString(2131697493));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setScrollable(false);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(0);
    XMediaEditor localXMediaEditor = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
    double d1 = ScreenUtil.SCREEN_HIGHT;
    Double.isNaN(d1);
    localXMediaEditor.setMinimumHeight((int)(d1 * 0.4D));
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getActivity().getString(2131697489));
  }
  
  protected void e(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(new SubmitHomeWorkFragment.9(this));
    }
  }
  
  protected void f()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$UIHandler.sendMessage(localMessage);
  }
  
  protected void g()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(getActivity());
    int j = 0;
    if (!bool)
    {
      QQToast.a(getActivity(), 0, 2131694422, 0).a();
      return;
    }
    Object localObject2 = this.jdField_d_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    TroopReportor.a("Grp_edu", "homework", "CompleteHw_Sub", 0, 0, new String[] { localObject1 });
    localObject1 = new HomeworkInfo();
    ((HomeworkInfo)localObject1).jdField_d_of_type_Long = this.jdField_a_of_type_Long;
    localObject2 = new JSONArray();
    Object localObject4 = new JSONArray();
    Object localObject3 = a((JSONArray)localObject2, (JSONArray)localObject4);
    ((Boolean)((List)localObject3).get(1)).booleanValue();
    bool = ((Boolean)((List)localObject3).get(2)).booleanValue();
    if (((Boolean)((List)localObject3).get(3)).booleanValue())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
      if (!TextUtils.isEmpty(""))
      {
        localObject1 = getActivity().getString(2131697487, new Object[] { "" });
        QQToast.a(getActivity(), (CharSequence)localObject1, 0).a();
      }
    }
    else if (!bool)
    {
      QQToast.a(getActivity(), 2131697486, 0).a();
      return;
    }
    localObject3 = new JSONArray();
    int k = ((JSONArray)localObject4).length();
    int i = 0;
    while (i < k)
    {
      JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(i);
      if (localJSONObject != null) {
        ((JSONArray)localObject3).put(localJSONObject);
      }
      i += 1;
    }
    k = ((JSONArray)localObject2).length();
    i = j;
    while (i < k)
    {
      localObject4 = ((JSONArray)localObject2).optJSONObject(i);
      if (localObject4 != null) {
        ((JSONArray)localObject3).put(localObject4);
      }
      i += 1;
    }
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("c", localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, ((JSONObject)localObject2).toString());
      }
    }
    catch (JSONException localJSONException)
    {
      label415:
      break label476;
    }
    try
    {
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        ((HomeworkInfo)localObject1).jdField_a_of_type_Long = 0L;
      } else {
        ((HomeworkInfo)localObject1).jdField_a_of_type_Long = Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue();
      }
      ((HomeworkInfo)localObject1).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).toString();
    }
    catch (Exception localException)
    {
      break label415;
    }
    localObject2 = DialogUtil.a(getActivity(), 230);
    localObject1 = new SubmitHomeWorkFragment.4(this, (HomeworkInfo)localObject1);
    ((QQCustomDialog)localObject2).setMessage(2131697485);
    ((QQCustomDialog)localObject2).setPositiveButton(2131697468, (DialogInterface.OnClickListener)localObject1);
    ((QQCustomDialog)localObject2).setNegativeButton(2131697462, (DialogInterface.OnClickListener)localObject1);
    ((QQCustomDialog)localObject2).show();
    return;
    label476:
    a(3, null, null, null);
  }
  
  protected void h()
  {
    Object localObject3 = this.jdField_d_of_type_JavaLangString;
    Object localObject2 = "";
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    localObject3 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo;
    if ((localObject3 != null) && (((HomeworkInfo)localObject3).jdField_b_of_type_JavaLangString != null)) {
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString;
    }
    TroopReportor.a("Grp_edu", "homework", "CompleteHw_Success", 0, 0, new String[] { localObject1, "", localObject2 });
    a(1, "CompleteHw_Pic", true);
    a(2, "CompleteHw_Video", true);
    a(3, "CompleteHw_Voice", true);
    localObject1 = new Intent();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{\"submit\":\"true\", \"hw_id\":");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject2).append("}");
    ((Intent)localObject1).putExtra("SubmitHomeWorkFragment:js_callback", ((StringBuilder)localObject2).toString());
    getActivity().setResult(-1, (Intent)localObject1);
    getActivity().finish();
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559849, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$UIHandler, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(ScreenUtil.SCREEN_HIGHT * 0.3F));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setAnimationTime(50);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener(new SubmitHomeWorkFragment.5(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOutsideDismissEnableCompat(true);
    InputMethodUtil.a(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$UIHandler.postDelayed(new SubmitHomeWorkFragment.6(this), 400L);
  }
  
  protected void k()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  protected void l()
  {
    Object localObject2 = this.jdField_d_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    TroopReportor.a("Grp_edu", "homework", "Subhw_hwDetail", 0, 0, new String[] { localObject1 });
    localObject1 = ActionSheet.create(getActivity());
    localObject2 = (ViewGroup)getActivity().getLayoutInflater().inflate(2131560672, null);
    XMediaEditor localXMediaEditor = (XMediaEditor)((ViewGroup)localObject2).findViewById(2131368330);
    localXMediaEditor.setMaxHeight(ScreenUtil.SCREEN_HIGHT - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getHeight() - ViewUtils.a(getActivity()) - ScreenUtil.dip2px(122.0F));
    localXMediaEditor.setShowType(1);
    Object localObject3 = (TextView)((ViewGroup)localObject2).findViewById(2131368234);
    View localView = ((ViewGroup)localObject2).findViewById(2131368233);
    HomeworkInfo localHomeworkInfo = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo;
    if (localHomeworkInfo != null)
    {
      if (!TextUtils.isEmpty(localHomeworkInfo.jdField_a_of_type_JavaLangString)) {
        ((TextView)localObject3).setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_d_of_type_JavaLangString))
      {
        localObject3 = (Integer)HomeWorkConstants.a.get(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_d_of_type_JavaLangString);
        if (localObject3 != null) {
          localView.setBackgroundResource(((Integer)localObject3).intValue());
        }
      }
    }
    localView = ((ViewGroup)localObject2).findViewById(2131368232);
    e(localView);
    localView.setOnClickListener(new SubmitHomeWorkFragment.7(this, (ActionSheet)localObject1));
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localXMediaEditor.setData(this.jdField_b_of_type_JavaLangString);
    }
    ((ActionSheet)localObject1).addView((View)localObject2);
    InputMethodUtil.a(getActivity());
    ((ActionSheet)localObject1).setAnimationTime(300);
    ((ActionSheet)localObject1).show();
  }
  
  protected void m()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label23:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    if (paramInt1 != 258)
    {
      if (paramInt1 != 260) {
        return;
      }
      if (paramInt2 == -1)
      {
        if (!NetworkUtil.isNetSupport(getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "no network toast from capture");
          }
          QQToast.a(getActivity(), 2131697226, 0).a();
          return;
        }
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
        {
          try
          {
            BaseImageUtil.a(getActivity(), jdField_a_of_type_JavaLangString);
          }
          catch (Exception paramIntent)
          {
            QLog.d("SubmitHomeWorkFragment", 1, "onActivityResult save exception", paramIntent);
          }
          paramIntent = new ImageInfo(jdField_a_of_type_JavaLangString);
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
          return;
        }
        QQToast.a(getActivity(), 2131694911, 0).a();
        QLog.d("SubmitHomeWorkFragment", 1, new Object[] { "onActivityResult path=%s", jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        paramInt1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        StringBuilder localStringBuilder;
        if (!TextUtils.isEmpty(paramIntent)) {
          if (paramInt1 != -2147483648)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt1, paramIntent);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("merging: ");
              localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
              QLog.d("SubmitHomeWorkFragment", 2, localStringBuilder.toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SubmitHomeWorkFragment", 2, "no index found");
          }
        }
        if ((!TextUtils.isEmpty(paramIntent)) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("提交新作业->");
          localStringBuilder.append(paramIntent);
          QLog.d("SubmitHomeWorkFragment", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "Return from entry");
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (((Boolean)a(new JSONArray(), new JSONArray()).get(0)).booleanValue())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      SubmitHomeWorkFragment.8 local8 = new SubmitHomeWorkFragment.8(this);
      localQQCustomDialog.setMessage(2131697488);
      localQQCustomDialog.setPositiveButton(2131697467, local8);
      localQQCustomDialog.setNegativeButton(2131697462, local8);
      localQQCustomDialog.show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131373255) {
      b(paramView);
    } else if (i == 2131373262) {
      c(paramView);
    } else if (i == 2131373263) {
      d(paramView);
    } else if (i == 2131371491) {
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null)
    {
      HomeworkObserver localHomeworkObserver = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver;
      if (localHomeworkObserver != null) {
        localAppInterface.removeObserver(localHomeworkObserver);
      }
    }
    HWTroopUtils.a();
    if (this.jdField_e_of_type_Boolean)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$UIHandler.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772004, 2130772344);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0) != 259) {
      return;
    }
    this.jdField_d_of_type_Boolean = ImageItem.a(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.jdField_d_of_type_Boolean);
  }
  
  public void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */