package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import apxu;
import axqw;
import bcrn;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.TabBarView2;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class QfileTabBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bcrn jdField_a_of_type_Bcrn = new apxu(this);
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = null;
  public BaseFileAssistantActivity a;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  public TabBarView2 a;
  String jdField_a_of_type_JavaLangString;
  HashMap<Integer, Class<? extends QfileBaseTabView>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  HashMap<Integer, QfileBaseTabView> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int c;
  public HashMap<Integer, Integer> c;
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
    this.jdField_c_of_type_JavaUtilHashMap = new LinkedHashMap();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560470, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131367599));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131376781));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376783));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this.jdField_a_of_type_Bcrn);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setBackgroundDrawable(null);
  }
  
  private void c(int paramInt)
  {
    if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {}
    do
    {
      do
      {
        return;
        switch (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue())
        {
        default: 
          return;
        case 3: 
          if (this.jdField_c_of_type_Int == 1)
          {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
            return;
          }
          break;
        case 1118: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
          return;
        case 1111: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
          return;
        case 1119: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
          return;
        case 1110: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
          return;
        case 1114: 
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_c_of_type_Int != 2);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_c_of_type_Int != 2);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
    return;
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.b();
  }
  
  /* Error */
  public QfileBaseTabView a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: iload_1
    //   5: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 165	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView
    //   14: astore 5
    //   16: aload 5
    //   18: ifnull +6 -> 24
    //   21: aload 5
    //   23: areturn
    //   24: aload_0
    //   25: getfield 52	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   28: iload_1
    //   29: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 114	java/lang/Integer
    //   38: invokevirtual 130	java/lang/Integer:intValue	()I
    //   41: istore_2
    //   42: new 172	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 173	java/util/ArrayList:<init>	()V
    //   49: astore 6
    //   51: aload 6
    //   53: new 175	apxv
    //   56: dup
    //   57: aload_0
    //   58: new 177	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   65: getstatic 183	ajsf:aV	Ljava/lang/String;
    //   68: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 189
    //   73: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: iconst_0
    //   80: iconst_0
    //   81: iconst_1
    //   82: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   85: invokeinterface 201 2 0
    //   90: pop
    //   91: aload 6
    //   93: new 175	apxv
    //   96: dup
    //   97: aload_0
    //   98: new 177	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 183	ajsf:aV	Ljava/lang/String;
    //   108: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 203
    //   113: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: iconst_0
    //   120: iconst_0
    //   121: iconst_1
    //   122: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   125: invokeinterface 201 2 0
    //   130: pop
    //   131: new 172	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 173	java/util/ArrayList:<init>	()V
    //   138: astore 7
    //   140: aload 7
    //   142: new 175	apxv
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 208	apti:a	()Lapti;
    //   150: invokevirtual 210	apti:b	()Ljava/lang/String;
    //   153: iconst_0
    //   154: iconst_0
    //   155: iconst_1
    //   156: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   159: invokeinterface 201 2 0
    //   164: pop
    //   165: aload_0
    //   166: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   169: invokevirtual 213	com/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity:e	()I
    //   172: bipush 8
    //   174: if_icmpne +377 -> 551
    //   177: iconst_1
    //   178: istore_3
    //   179: aload_0
    //   180: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   183: ifnull +373 -> 556
    //   186: aload_0
    //   187: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   193: invokevirtual 223	java/lang/String:length	()I
    //   196: ifeq +360 -> 556
    //   199: iconst_1
    //   200: istore 4
    //   202: iload_2
    //   203: lookupswitch	default:+241->444, 3:+359->562, 4:+451->654, 5:+497->700, 6:+543->746, 7:+589->792, 8:+681->884, 9:+745->948, 10:+838->1041, 11:+1012->1215, 12:+1106->1309, 13:+1131->1334, 14:+1156->1359, 15:+1208->1411, 16:+1180->1383, 17:+1236->1439, 18:+1264->1467, 19:+1292->1495, 20:+635->838, 21:+405->608, 110:+862->1065, 111:+1037->1240, 114:+902->1105, 118:+705->908, 119:+769->972, 1110:+1411->1614, 1111:+1350->1553, 1114:+1441->1644, 1118:+1320->1523, 1119:+1381->1584
    //   445: iconst_2
    //   446: iconst_0
    //   447: invokevirtual 226	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFocusable	(Z)V
    //   450: aload 5
    //   452: instanceof 228
    //   455: ifeq +15 -> 470
    //   458: aload 5
    //   460: checkcast 228	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView
    //   463: aload_0
    //   464: getfield 132	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_c_of_type_Int	I
    //   467: invokevirtual 231	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:setAttribution	(I)V
    //   470: aload_0
    //   471: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   474: instanceof 233
    //   477: ifeq +17 -> 494
    //   480: aload_0
    //   481: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   484: checkcast 233	com/tencent/mobileqq/filemanager/activity/FMActivity
    //   487: invokevirtual 236	com/tencent/mobileqq/filemanager/activity/FMActivity:a	()Lcom/tencent/mobileqq/filemanager/widget/SendBottomBar;
    //   490: iload_2
    //   491: invokevirtual 239	com/tencent/mobileqq/filemanager/widget/SendBottomBar:setAttribution	(I)V
    //   494: aload_0
    //   495: getfield 47	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   498: iload_1
    //   499: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   502: aload 5
    //   504: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: aload 5
    //   510: areturn
    //   511: astore 5
    //   513: aconst_null
    //   514: astore 5
    //   516: ldc 245
    //   518: iconst_1
    //   519: new 177	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   526: ldc 247
    //   528: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: iload_1
    //   532: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: ldc 252
    //   537: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 257	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: iconst_3
    //   547: istore_2
    //   548: goto -506 -> 42
    //   551: iconst_0
    //   552: istore_3
    //   553: goto -374 -> 179
    //   556: iconst_0
    //   557: istore 4
    //   559: goto -357 -> 202
    //   562: iload 4
    //   564: ifeq +28 -> 592
    //   567: new 259	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView
    //   570: dup
    //   571: aload_0
    //   572: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   575: aload_0
    //   576: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   579: invokespecial 262	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   582: astore 5
    //   584: aload 5
    //   586: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   589: goto -145 -> 444
    //   592: new 259	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView
    //   595: dup
    //   596: aload_0
    //   597: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   600: invokespecial 266	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView:<init>	(Landroid/content/Context;)V
    //   603: astore 5
    //   605: goto -21 -> 584
    //   608: iload 4
    //   610: ifeq +28 -> 638
    //   613: new 268	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView
    //   616: dup
    //   617: aload_0
    //   618: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   621: aload_0
    //   622: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   625: invokespecial 269	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   628: astore 5
    //   630: aload 5
    //   632: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   635: goto -191 -> 444
    //   638: new 268	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView
    //   641: dup
    //   642: aload_0
    //   643: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   646: invokespecial 270	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView:<init>	(Landroid/content/Context;)V
    //   649: astore 5
    //   651: goto -21 -> 630
    //   654: iload 4
    //   656: ifeq +28 -> 684
    //   659: new 272	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView
    //   662: dup
    //   663: aload_0
    //   664: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   667: aload_0
    //   668: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   671: invokespecial 273	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   674: astore 5
    //   676: aload 5
    //   678: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   681: goto -237 -> 444
    //   684: new 272	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView
    //   687: dup
    //   688: aload_0
    //   689: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   692: invokespecial 274	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView:<init>	(Landroid/content/Context;)V
    //   695: astore 5
    //   697: goto -21 -> 676
    //   700: iload 4
    //   702: ifeq +28 -> 730
    //   705: new 276	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView
    //   708: dup
    //   709: aload_0
    //   710: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   713: aload_0
    //   714: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   717: invokespecial 277	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   720: astore 5
    //   722: aload 5
    //   724: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   727: goto -283 -> 444
    //   730: new 276	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView
    //   733: dup
    //   734: aload_0
    //   735: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   738: invokespecial 278	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView:<init>	(Landroid/content/Context;)V
    //   741: astore 5
    //   743: goto -21 -> 722
    //   746: iload 4
    //   748: ifeq +28 -> 776
    //   751: new 280	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView
    //   754: dup
    //   755: aload_0
    //   756: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   759: aload_0
    //   760: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   763: invokespecial 281	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   766: astore 5
    //   768: aload 5
    //   770: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   773: goto -329 -> 444
    //   776: new 280	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView
    //   779: dup
    //   780: aload_0
    //   781: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   784: invokespecial 282	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView:<init>	(Landroid/content/Context;)V
    //   787: astore 5
    //   789: goto -21 -> 768
    //   792: iload 4
    //   794: ifeq +28 -> 822
    //   797: new 284	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView
    //   800: dup
    //   801: aload_0
    //   802: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   805: aload_0
    //   806: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   809: invokespecial 285	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   812: astore 5
    //   814: aload 5
    //   816: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   819: goto -375 -> 444
    //   822: new 284	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView
    //   825: dup
    //   826: aload_0
    //   827: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   830: invokespecial 286	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView:<init>	(Landroid/content/Context;)V
    //   833: astore 5
    //   835: goto -21 -> 814
    //   838: iload 4
    //   840: ifeq +28 -> 868
    //   843: new 288	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView
    //   846: dup
    //   847: aload_0
    //   848: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   851: aload_0
    //   852: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   855: invokespecial 289	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   858: astore 5
    //   860: aload 5
    //   862: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   865: goto -421 -> 444
    //   868: new 288	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView
    //   871: dup
    //   872: aload_0
    //   873: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   876: invokespecial 290	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView:<init>	(Landroid/content/Context;)V
    //   879: astore 5
    //   881: goto -21 -> 860
    //   884: new 292	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView
    //   887: dup
    //   888: aload_0
    //   889: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   892: aload 7
    //   894: iconst_1
    //   895: invokespecial 295	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   898: astore 5
    //   900: aload 5
    //   902: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   905: goto -461 -> 444
    //   908: new 297	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView
    //   911: dup
    //   912: aload_0
    //   913: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   916: aload 7
    //   918: new 299	com/tencent/util/Pair
    //   921: dup
    //   922: ldc_w 300
    //   925: invokestatic 305	ajyc:a	(I)Ljava/lang/String;
    //   928: iconst_5
    //   929: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   932: invokespecial 308	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   935: invokespecial 311	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView:<init>	(Landroid/content/Context;Ljava/util/List;Lcom/tencent/util/Pair;)V
    //   938: astore 5
    //   940: aload 5
    //   942: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   945: goto -501 -> 444
    //   948: new 313	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView
    //   951: dup
    //   952: aload_0
    //   953: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   956: aload 7
    //   958: iconst_1
    //   959: invokespecial 314	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   962: astore 5
    //   964: aload 5
    //   966: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   969: goto -525 -> 444
    //   972: iload_3
    //   973: ifeq +44 -> 1017
    //   976: aload 7
    //   978: new 175	apxv
    //   981: dup
    //   982: aload_0
    //   983: new 177	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   990: getstatic 183	ajsf:aV	Ljava/lang/String;
    //   993: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc_w 316
    //   999: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: iconst_1
    //   1006: iconst_1
    //   1007: iconst_1
    //   1008: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1011: invokeinterface 201 2 0
    //   1016: pop
    //   1017: new 318	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelPicTabView
    //   1020: dup
    //   1021: aload_0
    //   1022: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1025: aload 7
    //   1027: iconst_1
    //   1028: invokespecial 319	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelPicTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1031: astore 5
    //   1033: aload 5
    //   1035: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1038: goto -594 -> 444
    //   1041: new 321	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView
    //   1044: dup
    //   1045: aload_0
    //   1046: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1049: aload 7
    //   1051: iconst_1
    //   1052: invokespecial 322	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1055: astore 5
    //   1057: aload 5
    //   1059: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1062: goto -618 -> 444
    //   1065: new 297	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView
    //   1068: dup
    //   1069: aload_0
    //   1070: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1073: aload 7
    //   1075: new 299	com/tencent/util/Pair
    //   1078: dup
    //   1079: ldc_w 323
    //   1082: invokestatic 305	ajyc:a	(I)Ljava/lang/String;
    //   1085: iconst_3
    //   1086: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1089: invokespecial 308	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1092: invokespecial 311	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView:<init>	(Landroid/content/Context;Ljava/util/List;Lcom/tencent/util/Pair;)V
    //   1095: astore 5
    //   1097: aload 5
    //   1099: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1102: goto -658 -> 444
    //   1105: aload 7
    //   1107: new 175	apxv
    //   1110: dup
    //   1111: aload_0
    //   1112: invokestatic 208	apti:a	()Lapti;
    //   1115: invokevirtual 325	apti:c	()Ljava/lang/String;
    //   1118: iconst_1
    //   1119: iconst_0
    //   1120: iconst_0
    //   1121: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1124: invokeinterface 201 2 0
    //   1129: pop
    //   1130: aload 7
    //   1132: new 175	apxv
    //   1135: dup
    //   1136: aload_0
    //   1137: new 177	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1144: invokestatic 208	apti:a	()Lapti;
    //   1147: invokevirtual 210	apti:b	()Ljava/lang/String;
    //   1150: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: ldc_w 327
    //   1156: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: iconst_1
    //   1163: iconst_0
    //   1164: iconst_0
    //   1165: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1168: invokeinterface 201 2 0
    //   1173: pop
    //   1174: new 297	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView
    //   1177: dup
    //   1178: aload_0
    //   1179: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1182: aload 7
    //   1184: new 299	com/tencent/util/Pair
    //   1187: dup
    //   1188: ldc_w 328
    //   1191: invokestatic 305	ajyc:a	(I)Ljava/lang/String;
    //   1194: bipush 11
    //   1196: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1199: invokespecial 308	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1202: invokespecial 311	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView:<init>	(Landroid/content/Context;Ljava/util/List;Lcom/tencent/util/Pair;)V
    //   1205: astore 5
    //   1207: aload 5
    //   1209: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1212: goto -768 -> 444
    //   1215: new 330	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1218: dup
    //   1219: aload_0
    //   1220: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1223: iconst_3
    //   1224: aload 7
    //   1226: iconst_1
    //   1227: invokespecial 333	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1230: astore 5
    //   1232: aload 5
    //   1234: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1237: goto -793 -> 444
    //   1240: iload_3
    //   1241: ifeq +44 -> 1285
    //   1244: aload 7
    //   1246: new 175	apxv
    //   1249: dup
    //   1250: aload_0
    //   1251: new 177	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1258: getstatic 183	ajsf:aV	Ljava/lang/String;
    //   1261: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: ldc_w 335
    //   1267: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: iconst_0
    //   1274: iconst_1
    //   1275: iconst_1
    //   1276: invokespecial 196	apxv:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1279: invokeinterface 201 2 0
    //   1284: pop
    //   1285: new 337	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelMediaTabView
    //   1288: dup
    //   1289: aload_0
    //   1290: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1293: aload 7
    //   1295: iconst_1
    //   1296: invokespecial 338	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelMediaTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1299: astore 5
    //   1301: aload 5
    //   1303: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1306: goto -862 -> 444
    //   1309: new 330	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1312: dup
    //   1313: aload_0
    //   1314: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1317: iconst_1
    //   1318: aload 7
    //   1320: iconst_1
    //   1321: invokespecial 333	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1324: astore 5
    //   1326: aload 5
    //   1328: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1331: goto -887 -> 444
    //   1334: new 330	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1337: dup
    //   1338: aload_0
    //   1339: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1342: iconst_2
    //   1343: aload 7
    //   1345: iconst_1
    //   1346: invokespecial 333	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1349: astore 5
    //   1351: aload 5
    //   1353: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1356: goto -912 -> 444
    //   1359: new 340	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView
    //   1362: dup
    //   1363: aload_0
    //   1364: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1367: aload 7
    //   1369: iconst_1
    //   1370: invokespecial 341	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1373: astore 5
    //   1375: aload 5
    //   1377: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1380: goto -936 -> 444
    //   1383: new 343	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1386: dup
    //   1387: aload_0
    //   1388: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1391: ldc_w 345
    //   1394: aload_0
    //   1395: getfield 347	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1398: invokespecial 350	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1401: astore 5
    //   1403: aload 5
    //   1405: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1408: goto -964 -> 444
    //   1411: new 343	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1414: dup
    //   1415: aload_0
    //   1416: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1419: ldc_w 352
    //   1422: aload_0
    //   1423: getfield 347	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1426: invokespecial 350	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1429: astore 5
    //   1431: aload 5
    //   1433: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1436: goto -992 -> 444
    //   1439: new 343	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1442: dup
    //   1443: aload_0
    //   1444: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1447: ldc_w 354
    //   1450: aload_0
    //   1451: getfield 347	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1454: invokespecial 350	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1457: astore 5
    //   1459: aload 5
    //   1461: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1464: goto -1020 -> 444
    //   1467: new 343	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1470: dup
    //   1471: aload_0
    //   1472: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1475: ldc_w 356
    //   1478: aload_0
    //   1479: getfield 347	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1482: invokespecial 350	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1485: astore 5
    //   1487: aload 5
    //   1489: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1492: goto -1048 -> 444
    //   1495: new 343	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1498: dup
    //   1499: aload_0
    //   1500: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1503: ldc_w 358
    //   1506: aload_0
    //   1507: getfield 347	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1510: invokespecial 350	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1513: astore 5
    //   1515: aload 5
    //   1517: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1520: goto -1076 -> 444
    //   1523: new 292	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView
    //   1526: dup
    //   1527: aload_0
    //   1528: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1531: aload 6
    //   1533: iconst_0
    //   1534: invokespecial 295	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1537: astore 5
    //   1539: aload 5
    //   1541: iconst_1
    //   1542: invokevirtual 361	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1545: aload 5
    //   1547: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1550: goto -1106 -> 444
    //   1553: new 330	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1556: dup
    //   1557: aload_0
    //   1558: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1561: iconst_3
    //   1562: aload 6
    //   1564: iconst_0
    //   1565: invokespecial 333	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1568: astore 5
    //   1570: aload 5
    //   1572: iconst_1
    //   1573: invokevirtual 361	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1576: aload 5
    //   1578: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1581: goto -1137 -> 444
    //   1584: new 313	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView
    //   1587: dup
    //   1588: aload_0
    //   1589: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1592: aload 6
    //   1594: iconst_0
    //   1595: invokespecial 314	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1598: astore 5
    //   1600: aload 5
    //   1602: iconst_1
    //   1603: invokevirtual 361	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1606: aload 5
    //   1608: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1611: goto -1167 -> 444
    //   1614: new 321	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView
    //   1617: dup
    //   1618: aload_0
    //   1619: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1622: aload 6
    //   1624: iconst_0
    //   1625: invokespecial 322	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1628: astore 5
    //   1630: aload 5
    //   1632: iconst_1
    //   1633: invokevirtual 361	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1636: aload 5
    //   1638: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1641: goto -1197 -> 444
    //   1644: new 340	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView
    //   1647: dup
    //   1648: aload_0
    //   1649: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1652: aload 6
    //   1654: iconst_0
    //   1655: invokespecial 341	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1658: astore 5
    //   1660: aload 5
    //   1662: iconst_1
    //   1663: invokevirtual 361	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1666: aload 5
    //   1668: invokevirtual 264	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1671: goto -1227 -> 444
    //   1674: astore 6
    //   1676: goto -1160 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1679	0	this	QfileTabBarView
    //   0	1679	1	paramInt	int
    //   41	507	2	i	int
    //   178	1063	3	j	int
    //   200	639	4	k	int
    //   14	495	5	localQfileBaseTabView	QfileBaseTabView
    //   511	1	5	localException1	java.lang.Exception
    //   514	1153	5	localObject	java.lang.Object
    //   49	1604	6	localArrayList1	ArrayList
    //   1674	1	6	localException2	java.lang.Exception
    //   138	1230	7	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   0	16	511	java/lang/Exception
    //   24	42	1674	java/lang/Exception
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.i();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setVisibility(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(this.jdField_a_of_type_Int, paramString);
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a(paramArrayList);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).a(paramSet);
    }
  }
  
  boolean a()
  {
    return true;
  }
  
  public int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(0);
      i += 1;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.c();
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelected(false);
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void b(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == localQfileBaseTabView) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
    {
      if (a()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.q();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.m();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.j();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setExpandGroup(true);
      if (a()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.n();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView, -1, -1);
    }
    c(paramInt);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(this.jdField_a_of_type_Int, paramString, false, false, true);
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).c(paramArrayList);
    }
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.b(paramArrayList);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void setAttribution(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setHeaderScrollView(HeaderScrollView paramHeaderScrollView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = paramHeaderScrollView;
  }
  
  public void setMemory(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(j))).intValue() != paramInt)
      {
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelectedTab(i, true);
      }
    }
  }
  
  public void setSortType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setSortType(paramInt);
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      i = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.u();
  }
  
  public void setUin(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setWYSubAppId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */