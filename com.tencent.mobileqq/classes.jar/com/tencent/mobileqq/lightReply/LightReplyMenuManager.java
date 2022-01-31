package com.tencent.mobileqq.lightReply;

import aebv;
import aebw;
import aebx;
import aebz;
import aeca;
import aecd;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class LightReplyMenuManager
{
  private static LightReplyMenuManager jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public int a;
  public LinearLayout a;
  public FacePicDectect a;
  private LightReplyAdapter jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  public final HashMap a;
  public List a;
  public boolean a;
  public int b;
  public List b;
  public boolean b;
  public int c;
  public List c;
  public boolean c;
  public int d;
  private boolean d;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g = AIOUtils.a(42.0F, BaseApplicationImpl.getContext().getResources());
  private int h = AIOUtils.a(28.0F, BaseApplicationImpl.getContext().getResources());
  
  private LightReplyMenuManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Int = 400;
    this.jdField_c_of_type_Int = 400;
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect = new FacePicDectect();
    this.jdField_d_of_type_Int = AIOUtils.a(83.0F, BaseApplicationImpl.getContext().getResources());
    a(true);
  }
  
  public static LightReplyMenuManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) {
      return jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null)
      {
        LightReplyMenuManager localLightReplyMenuManager1 = jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager;
        return localLightReplyMenuManager1;
      }
    }
    finally {}
    jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager = new LightReplyMenuManager();
    LightReplyMenuManager localLightReplyMenuManager2 = jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager;
    return localLightReplyMenuManager2;
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramLinearLayout, "translationY", new float[] { 0.0F, this.f });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramLinearLayout, "alpha", new float[] { 0.1F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.setTarget(paramLinearLayout);
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void a(JSONArray paramJSONArray, List paramList)
  {
    int k = paramJSONArray.length();
    int i = 0;
    for (;;)
    {
      if (i < k) {
        try
        {
          JSONArray localJSONArray = paramJSONArray.getJSONArray(i);
          int m = localJSONArray.length();
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < m)
          {
            Object localObject = localJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject).getString("emo_id");
            localObject = new LightReplyEmojs(str, ((JSONObject)localObject).getString("surl"), ((JSONObject)localObject).getString("burl"), ((JSONObject)localObject).getString("android"));
            localArrayList.add(localObject);
            this.jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
            j += 1;
          }
          paramList.add(localArrayList);
          i += 1;
        }
        catch (Exception paramJSONArray)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightReplyMenuManager", 2, "parsed error");
          }
        }
      }
    }
  }
  
  private void b(LinearLayout paramLinearLayout)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramLinearLayout != null) && (paramLinearLayout.getVisibility() == 0))
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramLinearLayout, "translationY", new float[] { this.f, 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramLinearLayout, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.setTarget(paramLinearLayout);
      localAnimatorSet.setDuration(400L);
      localObjectAnimator1.addListener(new aeca(this));
      localAnimatorSet.start();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (List localList = this.jdField_a_of_type_JavaUtilList;; localList = this.jdField_b_of_type_JavaUtilList)
    {
      int i = (int)(Math.random() * localList.size());
      if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter != null) && (localList.size() > 0))
      {
        this.jdField_c_of_type_JavaUtilList = ((List)localList.get(i));
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter.jdField_b_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter.notifyDataSetChanged();
      }
      return;
    }
  }
  
  public String a(List paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(((LightReplyEmojs)paramList.next()).emoCode);
    }
    return localJSONArray.toString();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (!this.jdField_c_of_type_Boolean))
    {
      ThreadManager.getUIHandler().post(new aebz(this));
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, String paramString, long paramLong, int paramInt2, Drawable paramDrawable, LightReplyMenuManager.LightReplyEmotionClickListener paramLightReplyEmotionClickListener, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (paramViewGroup == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightReplyMenuManager", 2, "showLightReplyLayout : parentView is null");
        }
        e();
        return;
      }
      finally {}
      if (a()) {
        break;
      }
      QQToast.a(paramContext, -1, "出错了，请稍后重试！", 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      e();
    }
    label88:
    Object localObject;
    if (paramInt4 > this.jdField_d_of_type_Int)
    {
      this.f = (-this.g);
      PicItemBuilder.e();
      this.jdField_d_of_type_Boolean = paramBoolean;
      localObject = (LinearLayout)paramViewGroup.findViewById(2131363033);
      if (localObject == null) {
        break label418;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      LightReplyMenuHorizontalListView localLightReplyMenuHorizontalListView = (LightReplyMenuHorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363034);
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter = ((LightReplyAdapter)localLightReplyMenuHorizontalListView.a());
      if (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter = new LightReplyAdapter(paramContext);
        localLightReplyMenuHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter);
      }
      paramViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject = localLightReplyMenuHorizontalListView;
      if (QLog.isColorLevel())
      {
        QLog.d("LightReplyMenuManager", 2, "showLightReplyLayout : replymenuLayout is not null");
        localObject = localLightReplyMenuHorizontalListView;
      }
      label206:
      ((LightReplyMenuHorizontalListView)localObject).setOnItemClickListener(new aebw(this, paramBoolean, paramString, paramLightReplyEmotionClickListener, paramContext, paramInt1, paramLong, paramInt2));
      paramLightReplyEmotionClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramLightReplyEmotionClickListener.addRule(14);
      paramLightReplyEmotionClickListener.topMargin = paramInt4;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramLightReplyEmotionClickListener);
      if (this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect == null) {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect = new FacePicDectect();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_e_of_type_Int >= 0) {
          break label496;
        }
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect.a(paramContext);
        this.jdField_e_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("LightReplyMenuManager", 2, "faceDetector not init, now init and countOfInitFaceDetect is " + this.jdField_e_of_type_Int);
        }
      }
      label357:
      if ((paramDrawable == null) || (!this.jdField_a_of_type_Boolean)) {
        break label710;
      }
    }
    label418:
    label705:
    label710:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramContext = new aebx(this, paramContext, paramBoolean, paramString);
        this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect.a(paramDrawable, paramContext);
        break;
        this.f = (this.g + this.h);
        break label88;
        if (QLog.isColorLevel()) {
          QLog.d("LightReplyMenuManager", 2, "showLightReplyLayout : replymenuLayout is null");
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(paramContext, 2130968653, null));
        localObject = (LightReplyMenuHorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363034);
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter = new LightReplyAdapter(paramContext);
        ((LightReplyMenuHorizontalListView)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyAdapter);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label206;
        label496:
        if (!QLog.isColorLevel()) {
          break label357;
        }
        QLog.d("LightReplyMenuManager", 2, "faceDetector reached max try count");
        break label357;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() == 0)
      {
        QQToast.a(paramContext, -1, "出错了，请稍后重试！", 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        QLog.e("LightReplyMenuManager", 1, "no reply face data");
        e();
        break;
      }
      b(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_e_of_type_Boolean = true;
      paramViewGroup = a(this.jdField_c_of_type_JavaUtilList);
      if (paramBoolean)
      {
        paramContext = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramContext instanceof QQAppInterface)) {
          break label705;
        }
      }
      for (paramContext = (QQAppInterface)paramContext;; paramContext = null)
      {
        ReportController.b(paramContext, "dc00899", "Grp_replyPic", "", "Emoji_box", "exp", 0, 0, paramString, paramViewGroup, "0", "");
        for (;;)
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LightReplyMenuManager", 2, "not need faceDetect, use no face");
          break;
          ReportController.b(null, "dc00899", "Grp_replyPic", "", "Emoji_box", "exp", 0, 0, paramString, paramViewGroup, "1", "");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((str1 != null) && ((paramBoolean) || (this.jdField_a_of_type_JavaLangString == null) || (!str1.equals(this.jdField_a_of_type_JavaLangString))))
    {
      String str2 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + str1 + "_" + "light_reply_emojs.json";
      this.jdField_a_of_type_JavaLangString = str1;
      if (QLog.isColorLevel()) {
        QLog.d("LightReplyMenuManager", 2, "read path" + str2);
      }
      ThreadManager.post(new aebv(this, str2), 5, null, false);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty());
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPic))
    {
      paramChatMessage = (MessageForPic)paramChatMessage;
      if ((paramChatMessage.width < this.jdField_b_of_type_Int) || (paramChatMessage.height < this.jdField_c_of_type_Int)) {}
    }
    do
    {
      return true;
      return false;
      if (!(paramChatMessage instanceof MessageForTroopFile)) {
        break;
      }
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
    } while ((paramChatMessage.width >= this.jdField_b_of_type_Int) && (paramChatMessage.height >= this.jdField_c_of_type_Int));
    return false;
    return false;
  }
  
  /* Error */
  public boolean a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 504	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +363 -> 369
    //   9: new 155	org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 507	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: ldc_w 509
    //   24: invokevirtual 513	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   27: astore 6
    //   29: aload 5
    //   31: ldc_w 515
    //   34: invokevirtual 513	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   37: astore 7
    //   39: getstatic 30	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   42: astore 4
    //   44: aload 4
    //   46: monitorenter
    //   47: aload_0
    //   48: aload 5
    //   50: ldc_w 517
    //   53: invokevirtual 521	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   56: putfield 523	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_Int	I
    //   59: aload_0
    //   60: aload 5
    //   62: ldc_w 525
    //   65: sipush 400
    //   68: invokevirtual 528	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   71: putfield 45	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_b_of_type_Int	I
    //   74: aload_0
    //   75: aload 5
    //   77: ldc_w 530
    //   80: sipush 400
    //   83: invokevirtual 528	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   86: putfield 47	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_c_of_type_Int	I
    //   89: aload_0
    //   90: getfield 43	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   93: invokevirtual 533	java/util/HashMap:clear	()V
    //   96: aload_0
    //   97: getfield 36	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   100: invokeinterface 534 1 0
    //   105: aload_0
    //   106: getfield 38	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   109: invokeinterface 534 1 0
    //   114: aload_0
    //   115: aload 6
    //   117: aload_0
    //   118: getfield 36	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   121: invokespecial 536	com/tencent/mobileqq/lightReply/LightReplyMenuManager:a	(Lorg/json/JSONArray;Ljava/util/List;)V
    //   124: aload_0
    //   125: aload 7
    //   127: aload_0
    //   128: getfield 38	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   131: invokespecial 536	com/tencent/mobileqq/lightReply/LightReplyMenuManager:a	(Lorg/json/JSONArray;Ljava/util/List;)V
    //   134: aload 4
    //   136: monitorexit
    //   137: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +84 -> 224
    //   143: ldc 189
    //   145: iconst_2
    //   146: new 371	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 538
    //   156: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: getfield 43	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   163: invokevirtual 539	java/util/HashMap:size	()I
    //   166: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: ldc_w 541
    //   172: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: getfield 36	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   179: invokeinterface 227 1 0
    //   184: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc_w 543
    //   190: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: getfield 38	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   197: invokeinterface 227 1 0
    //   202: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc_w 517
    //   208: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_0
    //   212: getfield 523	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_Int	I
    //   215: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: iload_2
    //   225: ifeq +114 -> 339
    //   228: invokestatic 414	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   231: invokevirtual 418	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   234: invokevirtual 446	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   237: astore 4
    //   239: new 371	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 372	java/lang/StringBuilder:<init>	()V
    //   246: invokestatic 414	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   249: invokevirtual 457	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   252: invokevirtual 462	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   255: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: getstatic 465	java/io/File:separator	Ljava/lang/String;
    //   261: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 4
    //   266: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 467
    //   272: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 469
    //   278: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 5
    //   286: new 459	java/io/File
    //   289: dup
    //   290: aload 5
    //   292: invokespecial 544	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: astore 6
    //   297: aload 6
    //   299: invokevirtual 547	java/io/File:exists	()Z
    //   302: ifeq +20 -> 322
    //   305: getstatic 30	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   308: astore 4
    //   310: aload 4
    //   312: monitorenter
    //   313: aload 6
    //   315: invokevirtual 550	java/io/File:delete	()Z
    //   318: pop
    //   319: aload 4
    //   321: monitorexit
    //   322: new 552	aecb
    //   325: dup
    //   326: aload_0
    //   327: aload 5
    //   329: aload_1
    //   330: invokespecial 555	aecb:<init>	(Lcom/tencent/mobileqq/lightReply/LightReplyMenuManager;Ljava/lang/String;Ljava/lang/String;)V
    //   333: iconst_5
    //   334: aconst_null
    //   335: iconst_0
    //   336: invokestatic 479	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   339: iconst_1
    //   340: istore_2
    //   341: iload_2
    //   342: ireturn
    //   343: astore_1
    //   344: aload 4
    //   346: monitorexit
    //   347: aload_1
    //   348: athrow
    //   349: astore_1
    //   350: iload_3
    //   351: istore_2
    //   352: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq -14 -> 341
    //   358: ldc 189
    //   360: iconst_2
    //   361: ldc_w 557
    //   364: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: iconst_0
    //   368: ireturn
    //   369: getstatic 30	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   372: astore 4
    //   374: aload 4
    //   376: monitorenter
    //   377: aload_0
    //   378: iconst_0
    //   379: putfield 523	com/tencent/mobileqq/lightReply/LightReplyMenuManager:jdField_a_of_type_Int	I
    //   382: aload 4
    //   384: monitorexit
    //   385: goto -161 -> 224
    //   388: astore_1
    //   389: aload 4
    //   391: monitorexit
    //   392: aload_1
    //   393: athrow
    //   394: astore_1
    //   395: aload 4
    //   397: monitorexit
    //   398: aload_1
    //   399: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	LightReplyMenuManager
    //   0	400	1	paramString	String
    //   0	400	2	paramBoolean	boolean
    //   1	350	3	bool	boolean
    //   17	311	5	localObject2	Object
    //   27	287	6	localObject3	Object
    //   37	89	7	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   47	137	343	finally
    //   344	347	343	finally
    //   9	47	349	java/lang/Exception
    //   347	349	349	java/lang/Exception
    //   377	385	388	finally
    //   389	392	388	finally
    //   313	322	394	finally
    //   395	398	394	finally
  }
  
  public void b()
  {
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect != null) {
      this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLightReplyFacePicDectect = new FacePicDectect();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.size() > 0;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      ThreadManager.getUIHandler().post(new aecd(this));
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightReplyMenuManager", 2, "reset pressed btn " + this.jdField_e_of_type_Boolean);
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localView != null) {
        localView.setAlpha(1.0F);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.LightReplyMenuManager
 * JD-Core Version:    0.7.0.1
 */