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
  protected static String A;
  protected boolean B;
  protected String C = null;
  protected String D = null;
  protected HomeworkInfo E = null;
  protected LinkedList<JSONObject> F;
  protected long G = 0L;
  protected String H = "";
  protected AppInterface I;
  protected HomeworkHandler J;
  protected HomeworkObserver K;
  protected SubmitHomeWorkFragment.UIHandler L;
  protected QQProgressDialog M = null;
  protected int N = 0;
  protected long O = 0L;
  protected long P = 0L;
  protected boolean Q = false;
  protected HomeworkInfo R = null;
  protected BroadcastReceiver S = new SubmitHomeWorkFragment.10(this);
  protected View a;
  protected InputMethodGuard b;
  protected View c;
  protected XMediaEditor d;
  protected XMediaEditor e;
  protected ViewGroup f;
  protected View g;
  protected ActionSheet w = null;
  protected CommonRecordSoundPanel x = null;
  protected boolean y = false;
  protected boolean z = false;
  
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
    return 2131626711;
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
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131911946));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof ImageInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131911939));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof AudioInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131911933));
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
    //   0: new 191	java/util/ArrayList
    //   3: dup
    //   4: iconst_3
    //   5: invokespecial 229	java/util/ArrayList:<init>	(I)V
    //   8: astore 13
    //   10: new 231	org/json/JSONArray
    //   13: dup
    //   14: aload_0
    //   15: getfield 233	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:e	Lcom/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor;
    //   18: invokevirtual 238	com/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor:getData	()Ljava/lang/String;
    //   21: invokespecial 241	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   24: astore 15
    //   26: new 231	org/json/JSONArray
    //   29: dup
    //   30: aload_0
    //   31: getfield 243	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:d	Lcom/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor;
    //   34: invokevirtual 238	com/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor:getData	()Ljava/lang/String;
    //   37: invokespecial 241	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   40: astore 14
    //   42: aload 15
    //   44: invokevirtual 246	org/json/JSONArray:length	()I
    //   47: istore 4
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: iload 4
    //   54: if_icmpge +30 -> 84
    //   57: aload 15
    //   59: iload_3
    //   60: invokevirtual 250	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   63: astore 16
    //   65: aload_0
    //   66: aload 16
    //   68: invokevirtual 253	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Lorg/json/JSONObject;)Z
    //   71: ifeq +336 -> 407
    //   74: aload_1
    //   75: aload 16
    //   77: invokevirtual 257	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   80: pop
    //   81: goto +326 -> 407
    //   84: aload 14
    //   86: invokevirtual 246	org/json/JSONArray:length	()I
    //   89: istore 4
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: iload 4
    //   96: if_icmpge +30 -> 126
    //   99: aload 14
    //   101: iload_3
    //   102: invokevirtual 250	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   105: astore 15
    //   107: aload_0
    //   108: aload 15
    //   110: invokevirtual 253	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Lorg/json/JSONObject;)Z
    //   113: ifeq +301 -> 414
    //   116: aload_2
    //   117: aload 15
    //   119: invokevirtual 257	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   122: pop
    //   123: goto +291 -> 414
    //   126: aload_0
    //   127: getfield 259	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:F	Ljava/util/LinkedList;
    //   130: invokevirtual 264	java/util/LinkedList:isEmpty	()Z
    //   133: istore 5
    //   135: iload 5
    //   137: ifne +9 -> 146
    //   140: iconst_1
    //   141: istore 5
    //   143: goto +6 -> 149
    //   146: iconst_0
    //   147: istore 5
    //   149: aload_0
    //   150: getfield 259	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:F	Ljava/util/LinkedList;
    //   153: invokevirtual 264	java/util/LinkedList:isEmpty	()Z
    //   156: ifne +32 -> 188
    //   159: aload_0
    //   160: getfield 243	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:d	Lcom/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor;
    //   163: invokevirtual 238	com/tencent/mobileqq/troop/homework/xmediaeditor/XMediaEditor:getData	()Ljava/lang/String;
    //   166: aload_0
    //   167: getfield 71	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:D	Ljava/lang/String;
    //   170: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   195: invokevirtual 246	org/json/JSONArray:length	()I
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
    //   234: invokevirtual 246	org/json/JSONArray:length	()I
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
    //   319: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +30 -> 352
    //   325: ldc_w 274
    //   328: iconst_2
    //   329: ldc_w 276
    //   332: aload_1
    //   333: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   356: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   359: invokeinterface 287 2 0
    //   364: pop
    //   365: aload 13
    //   367: iload 10
    //   369: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   372: invokeinterface 287 2 0
    //   377: pop
    //   378: aload 13
    //   380: iload 11
    //   382: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   385: invokeinterface 287 2 0
    //   390: pop
    //   391: aload 13
    //   393: iload 12
    //   395: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: invokeinterface 287 2 0
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
  
  protected void a(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.M == null)
        {
          this.M = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
          this.M.setCancelable(false);
          this.M.show();
        }
        this.M.c(paramInt);
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
      localObject1 = this.e;
    } else {
      localObject1 = this.d;
    }
    ArrayList localArrayList = ((XMediaEditor)localObject1).c(paramInt);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = localArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditItemInfoBase)((Iterator)localObject1).next();
      if (localObject2 != null) {
        localJSONArray.put(((EditItemInfoBase)localObject2).d());
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject2 = this.H;
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
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131911935));
        paramHomeworkInfo = ((StringBuilder)localObject).toString();
      }
      int i = this.N;
      if (i == 0)
      {
        this.N = (i + 1);
        if ((this.e != null) && (!paramArrayList1.isEmpty())) {
          this.e.a(paramArrayList1);
        }
        if ((this.d != null) && (!paramArrayList2.isEmpty())) {
          this.d.a(paramArrayList2);
        }
        paramArrayList1 = getString(2131895273, new Object[] { paramHomeworkInfo });
        QQToast.makeText(getActivity(), paramArrayList1, 0).show();
      }
      else
      {
        paramArrayList1 = getString(2131895271, new Object[] { paramHomeworkInfo });
        QQToast.makeText(getActivity(), paramArrayList1, 0).show();
      }
    }
    else if (paramInt == 1)
    {
      QQToast.makeText(getActivity(), 2131895242, 0).show();
    }
    else if (paramInt == 3)
    {
      QQToast.makeText(getActivity(), 2131895267, 0).show();
    }
    else if (paramInt == 2)
    {
      QQToast.makeText(getActivity(), 2131892111, 0).show();
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
    b();
    c();
    d();
    e();
    if (MobileQQ.sProcessId != 9) {
      a(getActivity());
    }
  }
  
  protected void a(HomeworkInfo paramHomeworkInfo)
  {
    Object localObject2 = this.e.getUploadErrorItemList();
    ArrayList localArrayList1 = this.d.getUploadErrorItemList();
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
      if ((this.J != null) && (paramHomeworkInfo != null))
      {
        a(2131895233);
        this.R = paramHomeworkInfo;
        this.O = paramHomeworkInfo.k;
        this.J.a(paramHomeworkInfo.k, paramHomeworkInfo.a, paramHomeworkInfo.d);
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
        if (localUploadEditItemInfo.i() == 1) {
          localArrayList3.add(localUploadEditItemInfo);
        } else if ((localUploadEditItemInfo.i() == 2) || (localUploadEditItemInfo.i() == 0)) {
          localArrayList1.add(localUploadEditItemInfo);
        }
      }
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UploadEditItemInfo)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((UploadEditItemInfo)localObject2).i() == 1) {
          localArrayList3.add(localObject2);
        } else if ((((UploadEditItemInfo)localObject2).i() == 2) || (((UploadEditItemInfo)localObject2).i() == 0)) {
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
            this.C = paramString.toString();
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
                this.F.add(localJSONObject);
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
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131911944));
      paramArrayList = ((StringBuilder)localObject).toString();
    }
    paramArrayList = getString(2131895273, new Object[] { paramArrayList });
    QQToast.makeText(getActivity(), paramArrayList, 0).show();
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
  
  protected <T extends View> T b(int paramInt)
  {
    return this.t.findViewById(paramInt);
  }
  
  protected EditText b(View paramView)
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
        localEditText = b(localViewGroup.getChildAt(i));
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
  
  protected void b()
  {
    this.H = "";
    this.L = new SubmitHomeWorkFragment.UIHandler(this, Looper.getMainLooper());
    this.F = new LinkedList();
    if (getActivity() == null) {
      localObject = null;
    } else {
      localObject = (AppInterface)getQBaseActivity().getAppRuntime();
    }
    this.I = ((AppInterface)localObject);
    Object localObject = this.I;
    if (localObject == null)
    {
      getActivity().finish();
      return;
    }
    this.J = ((HomeworkHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName()));
    this.K = new SubmitHomeWorkFragment.1(this);
    this.I.addObserver(this.K);
    if (!this.Q)
    {
      this.Q = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
      getActivity().registerReceiver(this.S, (IntentFilter)localObject);
    }
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
    if (this.t == null) {
      return;
    }
    this.a = b(2131446567);
    this.c = b(2131429705);
    this.b = ((InputMethodGuard)b(2131435836));
    this.b.setOnInputMethodChangeListener(this);
    this.e = ((XMediaEditor)b(2131435200));
    this.f = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131626710, null, false));
    this.e.setHeaderView(this.f);
    this.d = ((XMediaEditor)this.f.findViewById(2131435206));
    this.d.setLeftRightPadding(DisplayUtil.a(getActivity(), 12.0F));
    this.e.setLeftRightPadding(DisplayUtil.a(getActivity(), 12.0F));
    this.g = b(2131438865);
    f(this.g.findViewById(2131438866));
    this.g.findViewById(2131438866).setOnClickListener(this);
    View localView = b(2131440864);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localView = b(2131440871);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localView = b(2131440872);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i = this.e.b(1) + this.e.b(2);
    if (i >= 10)
    {
      if (System.currentTimeMillis() - this.P >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131911945));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131911943));
        QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
        this.P = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - i, getActivity(), this.I.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivity(paramView);
    InputMethodUtil.a(getActivity());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
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
        this.H = str2;
        this.G = localBundle.getLong("HomeWorkConstants:homework_id_default_request_key");
        if (this.G > 0L)
        {
          a(2131895222);
          this.J.a(this.G);
          return;
        }
        QQToast.makeText(getActivity(), 2131895269, 0).show();
        getActivity().finish();
        return;
      }
      QQToast.makeText(getActivity(), 2131895269, 0).show();
      getActivity().finish();
      return;
    }
    QQToast.makeText(getActivity(), 2131895269, 0).show();
    getActivity().finish();
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.e.b(1) + this.e.b(2) >= 10)
    {
      if (System.currentTimeMillis() - this.P >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131911947));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131911938));
        QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
        this.P = System.currentTimeMillis();
      }
      return;
    }
    A = TroopHWJsPlugin.a(getActivity(), 260);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onVideoBtnClick", String.format("mCameraPath=%s", new Object[] { A }) });
    }
    InputMethodUtil.a(getActivity());
  }
  
  protected void e()
  {
    a(2131895257, new SubmitHomeWorkFragment.2(this));
    c(2131895265, new SubmitHomeWorkFragment.3(this));
    a(getResources().getString(2131895266));
    this.d.setShowType(2);
    this.d.setExtraValue("troopuin", this.H);
    this.d.setScrollable(false);
    this.e.setShowType(0);
    XMediaEditor localXMediaEditor = this.e;
    double d1 = ScreenUtil.SCREEN_HIGHT;
    Double.isNaN(d1);
    localXMediaEditor.setMinimumHeight((int)(d1 * 0.4D));
    this.e.setSizeLimit(500);
    this.e.setExtraValue("troopuin", this.H);
    this.e.setHint(getActivity().getString(2131895262));
  }
  
  protected void e(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.e.b(3) >= 6)
    {
      if (System.currentTimeMillis() - this.P >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131911940));
        localStringBuilder.append(6);
        localStringBuilder.append(HardCodeUtil.a(2131911934));
        QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
        this.P = System.currentTimeMillis();
      }
      return;
    }
    InputMethodUtil.b(paramView);
    p();
  }
  
  protected void f()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.L.sendMessage(localMessage);
  }
  
  protected void f(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(new SubmitHomeWorkFragment.9(this));
    }
  }
  
  protected void g()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(getActivity());
    int j = 0;
    if (!bool)
    {
      QQToast.makeText(getActivity(), 0, 2131892102, 0).show();
      return;
    }
    Object localObject2 = this.H;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    TroopReportor.a("Grp_edu", "homework", "CompleteHw_Sub", 0, 0, new String[] { localObject1 });
    localObject1 = new HomeworkInfo();
    ((HomeworkInfo)localObject1).k = this.G;
    localObject2 = new JSONArray();
    Object localObject4 = new JSONArray();
    Object localObject3 = a((JSONArray)localObject2, (JSONArray)localObject4);
    ((Boolean)((List)localObject3).get(1)).booleanValue();
    bool = ((Boolean)((List)localObject3).get(2)).booleanValue();
    if (((Boolean)((List)localObject3).get(3)).booleanValue())
    {
      this.d.getHomeWorkItemList();
      if (!TextUtils.isEmpty(""))
      {
        localObject1 = getActivity().getString(2131895260, new Object[] { "" });
        QQToast.makeText(getActivity(), (CharSequence)localObject1, 0).show();
      }
    }
    else if (!bool)
    {
      QQToast.makeText(getActivity(), 2131895259, 0).show();
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
      if (TextUtils.isEmpty(this.H)) {
        ((HomeworkInfo)localObject1).a = 0L;
      } else {
        ((HomeworkInfo)localObject1).a = Long.valueOf(this.H).longValue();
      }
      ((HomeworkInfo)localObject1).d = ((JSONObject)localObject2).toString();
    }
    catch (Exception localException)
    {
      break label415;
    }
    localObject2 = DialogUtil.a(getActivity(), 230);
    localObject1 = new SubmitHomeWorkFragment.4(this, (HomeworkInfo)localObject1);
    ((QQCustomDialog)localObject2).setMessage(2131895258);
    ((QQCustomDialog)localObject2).setPositiveButton(2131895241, (DialogInterface.OnClickListener)localObject1);
    ((QQCustomDialog)localObject2).setNegativeButton(2131895235, (DialogInterface.OnClickListener)localObject1);
    ((QQCustomDialog)localObject2).show();
    return;
    label476:
    a(3, null, null, null);
  }
  
  protected void h()
  {
    Object localObject3 = this.H;
    Object localObject2 = "";
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    localObject3 = this.R;
    if ((localObject3 != null) && (((HomeworkInfo)localObject3).d != null)) {
      localObject2 = this.R.d;
    }
    TroopReportor.a("Grp_edu", "homework", "CompleteHw_Success", 0, 0, new String[] { localObject1, "", localObject2 });
    a(1, "CompleteHw_Pic", true);
    a(2, "CompleteHw_Video", true);
    a(3, "CompleteHw_Voice", true);
    localObject1 = new Intent();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{\"submit\":\"true\", \"hw_id\":");
    ((StringBuilder)localObject2).append(this.O);
    ((StringBuilder)localObject2).append("}");
    ((Intent)localObject1).putExtra("SubmitHomeWorkFragment:js_callback", ((StringBuilder)localObject2).toString());
    getActivity().setResult(-1, (Intent)localObject1);
    getActivity().finish();
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
          QQToast.makeText(getActivity(), 2131894999, 0).show();
          return;
        }
        if (!TextUtils.isEmpty(A))
        {
          try
          {
            BaseImageUtil.b(getActivity(), A);
          }
          catch (Exception paramIntent)
          {
            QLog.d("SubmitHomeWorkFragment", 1, "onActivityResult save exception", paramIntent);
          }
          paramIntent = new ImageInfo(A);
          this.e.a(paramIntent);
          return;
        }
        QQToast.makeText(getActivity(), 2131892637, 0).show();
        QLog.d("SubmitHomeWorkFragment", 1, new Object[] { "onActivityResult path=%s", A });
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
            this.d.a(paramInt1, paramIntent);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("merging: ");
              localStringBuilder.append(this.d.getData());
              QLog.d("SubmitHomeWorkFragment", 2, localStringBuilder.toString());
            }
            this.d.invalidate();
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
      localQQCustomDialog.setMessage(2131895261);
      localQQCustomDialog.setPositiveButton(2131895240, local8);
      localQQCustomDialog.setNegativeButton(2131895235, local8);
      localQQCustomDialog.show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131440864) {
      c(paramView);
    } else if (i == 2131440871) {
      d(paramView);
    } else if (i == 2131440872) {
      e(paramView);
    } else if (i == 2131438866) {
      s();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    AppInterface localAppInterface = this.I;
    if (localAppInterface != null)
    {
      HomeworkObserver localHomeworkObserver = this.K;
      if (localHomeworkObserver != null) {
        localAppInterface.removeObserver(localHomeworkObserver);
      }
    }
    HWTroopUtils.a();
    if (this.Q)
    {
      getActivity().unregisterReceiver(this.S);
      this.Q = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.L.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772007, 2130772436);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0) != 259) {
      return;
    }
    this.B = ImageItem.a(this.e, paramIntent, this.B);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  protected void p()
  {
    if (this.w == null)
    {
      this.w = ActionSheet.create(getActivity());
      this.x = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131625892, null));
      this.x.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.x));
      this.x.setBackgroundColor(-1);
      this.x.a(this.I, getQBaseActivity(), this.L, 0);
      this.x.setTimeOutTime(360000);
      this.x.setMinimumHeight((int)(ScreenUtil.SCREEN_HIGHT * 0.3F));
      this.w.addView(this.x);
      this.w.setAnimationTime(50);
      this.w.registerWatchDisMissActionListener(new SubmitHomeWorkFragment.5(this));
    }
    this.x.e();
    this.w.setOutsideDismissEnableCompat(true);
    InputMethodUtil.a(getActivity());
    this.w.show();
  }
  
  protected void q()
  {
    this.L.postDelayed(new SubmitHomeWorkFragment.6(this), 400L);
  }
  
  protected void r()
  {
    this.w.dismiss();
  }
  
  protected void s()
  {
    Object localObject2 = this.H;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    TroopReportor.a("Grp_edu", "homework", "Subhw_hwDetail", 0, 0, new String[] { localObject1 });
    localObject1 = ActionSheet.create(getActivity());
    localObject2 = (ViewGroup)getActivity().getLayoutInflater().inflate(2131626717, null);
    XMediaEditor localXMediaEditor = (XMediaEditor)((ViewGroup)localObject2).findViewById(2131435205);
    localXMediaEditor.setMaxHeight(ScreenUtil.SCREEN_HIGHT - this.p.getHeight() - ViewUtils.getStatusBarHeight(getActivity()) - ScreenUtil.dip2px(122.0F));
    localXMediaEditor.setShowType(1);
    Object localObject3 = (TextView)((ViewGroup)localObject2).findViewById(2131435102);
    View localView = ((ViewGroup)localObject2).findViewById(2131435101);
    HomeworkInfo localHomeworkInfo = this.E;
    if (localHomeworkInfo != null)
    {
      if (!TextUtils.isEmpty(localHomeworkInfo.c)) {
        ((TextView)localObject3).setText(this.E.c);
      }
      if (!TextUtils.isEmpty(this.E.g))
      {
        localObject3 = (Integer)HomeWorkConstants.n.get(this.E.g);
        if (localObject3 != null) {
          localView.setBackgroundResource(((Integer)localObject3).intValue());
        }
      }
    }
    localView = ((ViewGroup)localObject2).findViewById(2131435100);
    f(localView);
    localView.setOnClickListener(new SubmitHomeWorkFragment.7(this, (ActionSheet)localObject1));
    if (!TextUtils.isEmpty(this.C)) {
      localXMediaEditor.setData(this.C);
    }
    ((ActionSheet)localObject1).addView((View)localObject2);
    InputMethodUtil.a(getActivity());
    ((ActionSheet)localObject1).setAnimationTime(300);
    ((ActionSheet)localObject1).show();
  }
  
  protected void t()
  {
    QQProgressDialog localQQProgressDialog = this.M;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.M.dismiss();
      label23:
      this.M = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */