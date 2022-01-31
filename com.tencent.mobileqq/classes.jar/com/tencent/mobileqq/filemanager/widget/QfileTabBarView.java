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
import arvh;
import azqs;
import bevu;
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
  private bevu jdField_a_of_type_Bevu = new arvh(this);
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560664, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131367738));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131377349));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377351));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this.jdField_a_of_type_Bevu);
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
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
            return;
          }
          break;
        case 1118: 
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
          return;
        case 1111: 
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
          return;
        case 1119: 
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
          return;
        case 1110: 
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
          return;
        case 1114: 
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_c_of_type_Int != 2);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_c_of_type_Int != 2);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
    return;
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
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
    //   53: new 175	arvi
    //   56: dup
    //   57: aload_0
    //   58: new 177	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   65: getstatic 183	alof:aW	Ljava/lang/String;
    //   68: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 189
    //   73: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: iconst_0
    //   80: iconst_0
    //   81: iconst_1
    //   82: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   85: invokeinterface 201 2 0
    //   90: pop
    //   91: aload 6
    //   93: new 175	arvi
    //   96: dup
    //   97: aload_0
    //   98: new 177	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 183	alof:aW	Ljava/lang/String;
    //   108: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 203
    //   113: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: iconst_0
    //   120: iconst_0
    //   121: iconst_1
    //   122: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   125: invokeinterface 201 2 0
    //   130: pop
    //   131: new 172	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 173	java/util/ArrayList:<init>	()V
    //   138: astore 7
    //   140: aload 7
    //   142: new 175	arvi
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 208	arqx:a	()Larqx;
    //   150: invokevirtual 210	arqx:b	()Ljava/lang/String;
    //   153: iconst_0
    //   154: iconst_0
    //   155: iconst_1
    //   156: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   159: invokeinterface 201 2 0
    //   164: pop
    //   165: aload_0
    //   166: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   169: invokevirtual 213	com/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity:e	()I
    //   172: bipush 8
    //   174: if_icmpne +424 -> 598
    //   177: iconst_1
    //   178: istore_3
    //   179: aload_0
    //   180: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   183: ifnull +420 -> 603
    //   186: aload_0
    //   187: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   193: invokevirtual 223	java/lang/String:length	()I
    //   196: ifeq +407 -> 603
    //   199: iconst_1
    //   200: istore 4
    //   202: new 177	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   209: getstatic 226	alof:aX	Ljava/lang/String;
    //   212: invokestatic 231	bdzf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 233
    //   220: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc 235
    //   225: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 233
    //   230: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 8
    //   238: invokestatic 238	com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	()Ljava/lang/String;
    //   241: astore 9
    //   243: iload_2
    //   244: lookupswitch	default:+244->488, 3:+365->609, 4:+457->701, 5:+503->747, 6:+549->793, 7:+595->839, 8:+687->931, 9:+751->995, 10:+824->1068, 11:+998->1242, 12:+1072->1316, 13:+1097->1341, 14:+1122->1366, 15:+1174->1418, 16:+1146->1390, 17:+1202->1446, 18:+1230->1474, 19:+1258->1502, 20:+641->885, 21:+411->655, 110:+848->1092, 111:+1023->1267, 114:+888->1132, 118:+711->955, 119:+775->1019, 1110:+1377->1621, 1111:+1316->1560, 1114:+1407->1651, 1118:+1286->1530, 1119:+1347->1591
    //   489: iconst_2
    //   490: iconst_0
    //   491: invokevirtual 241	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFocusable	(Z)V
    //   494: aload 5
    //   496: instanceof 243
    //   499: ifeq +15 -> 514
    //   502: aload 5
    //   504: checkcast 243	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView
    //   507: aload_0
    //   508: getfield 132	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_c_of_type_Int	I
    //   511: invokevirtual 246	com/tencent/mobileqq/filemanager/activity/recentfile/QfileBaseRecentFileTabView:setAttribution	(I)V
    //   514: aload_0
    //   515: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   518: instanceof 248
    //   521: ifeq +17 -> 538
    //   524: aload_0
    //   525: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   528: checkcast 248	com/tencent/mobileqq/filemanager/activity/FMActivity
    //   531: invokevirtual 251	com/tencent/mobileqq/filemanager/activity/FMActivity:a	()Lcom/tencent/mobileqq/filemanager/widget/SendBottomBar;
    //   534: iload_2
    //   535: invokevirtual 254	com/tencent/mobileqq/filemanager/widget/SendBottomBar:setAttribution	(I)V
    //   538: aload_0
    //   539: getfield 47	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   542: iload_1
    //   543: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aload 5
    //   548: invokevirtual 258	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: pop
    //   552: aload 5
    //   554: areturn
    //   555: astore 5
    //   557: aconst_null
    //   558: astore 5
    //   560: ldc_w 260
    //   563: iconst_1
    //   564: new 177	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 262
    //   574: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload_1
    //   578: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 267
    //   584: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: iconst_3
    //   594: istore_2
    //   595: goto -553 -> 42
    //   598: iconst_0
    //   599: istore_3
    //   600: goto -421 -> 179
    //   603: iconst_0
    //   604: istore 4
    //   606: goto -404 -> 202
    //   609: iload 4
    //   611: ifeq +28 -> 639
    //   614: new 274	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView
    //   617: dup
    //   618: aload_0
    //   619: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   622: aload_0
    //   623: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   626: invokespecial 277	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   629: astore 5
    //   631: aload 5
    //   633: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   636: goto -148 -> 488
    //   639: new 274	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView
    //   642: dup
    //   643: aload_0
    //   644: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   647: invokespecial 281	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAllFileTabView:<init>	(Landroid/content/Context;)V
    //   650: astore 5
    //   652: goto -21 -> 631
    //   655: iload 4
    //   657: ifeq +28 -> 685
    //   660: new 283	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView
    //   663: dup
    //   664: aload_0
    //   665: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   668: aload_0
    //   669: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: invokespecial 284	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   675: astore 5
    //   677: aload 5
    //   679: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   682: goto -194 -> 488
    //   685: new 283	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView
    //   688: dup
    //   689: aload_0
    //   690: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   693: invokespecial 285	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTDocFileTabView:<init>	(Landroid/content/Context;)V
    //   696: astore 5
    //   698: goto -21 -> 677
    //   701: iload 4
    //   703: ifeq +28 -> 731
    //   706: new 287	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView
    //   709: dup
    //   710: aload_0
    //   711: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   714: aload_0
    //   715: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   718: invokespecial 288	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   721: astore 5
    //   723: aload 5
    //   725: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   728: goto -240 -> 488
    //   731: new 287	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView
    //   734: dup
    //   735: aload_0
    //   736: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   739: invokespecial 289	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentDocFileTabView:<init>	(Landroid/content/Context;)V
    //   742: astore 5
    //   744: goto -21 -> 723
    //   747: iload 4
    //   749: ifeq +28 -> 777
    //   752: new 291	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView
    //   755: dup
    //   756: aload_0
    //   757: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   760: aload_0
    //   761: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   764: invokespecial 292	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   767: astore 5
    //   769: aload 5
    //   771: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   774: goto -286 -> 488
    //   777: new 291	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView
    //   780: dup
    //   781: aload_0
    //   782: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   785: invokespecial 293	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentPicFileTabView:<init>	(Landroid/content/Context;)V
    //   788: astore 5
    //   790: goto -21 -> 769
    //   793: iload 4
    //   795: ifeq +28 -> 823
    //   798: new 295	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView
    //   801: dup
    //   802: aload_0
    //   803: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   806: aload_0
    //   807: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   810: invokespecial 296	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   813: astore 5
    //   815: aload 5
    //   817: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   820: goto -332 -> 488
    //   823: new 295	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView
    //   826: dup
    //   827: aload_0
    //   828: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   831: invokespecial 297	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentMediaFileTabView:<init>	(Landroid/content/Context;)V
    //   834: astore 5
    //   836: goto -21 -> 815
    //   839: iload 4
    //   841: ifeq +28 -> 869
    //   844: new 299	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView
    //   847: dup
    //   848: aload_0
    //   849: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   852: aload_0
    //   853: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   856: invokespecial 300	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   859: astore 5
    //   861: aload 5
    //   863: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   866: goto -378 -> 488
    //   869: new 299	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView
    //   872: dup
    //   873: aload_0
    //   874: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   877: invokespecial 301	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentAppFileTabView:<init>	(Landroid/content/Context;)V
    //   880: astore 5
    //   882: goto -21 -> 861
    //   885: iload 4
    //   887: ifeq +28 -> 915
    //   890: new 303	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView
    //   893: dup
    //   894: aload_0
    //   895: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   898: aload_0
    //   899: getfield 215	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   902: invokespecial 304	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   905: astore 5
    //   907: aload 5
    //   909: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   912: goto -424 -> 488
    //   915: new 303	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView
    //   918: dup
    //   919: aload_0
    //   920: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   923: invokespecial 305	com/tencent/mobileqq/filemanager/activity/recentfile/QfileRecentTencentDocFileTabView:<init>	(Landroid/content/Context;)V
    //   926: astore 5
    //   928: goto -21 -> 907
    //   931: new 307	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView
    //   934: dup
    //   935: aload_0
    //   936: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   939: aload 7
    //   941: iconst_1
    //   942: invokespecial 310	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   945: astore 5
    //   947: aload 5
    //   949: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   952: goto -464 -> 488
    //   955: new 312	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView
    //   958: dup
    //   959: aload_0
    //   960: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   963: aload 7
    //   965: new 314	com/tencent/util/Pair
    //   968: dup
    //   969: ldc_w 315
    //   972: invokestatic 320	alud:a	(I)Ljava/lang/String;
    //   975: iconst_5
    //   976: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   979: invokespecial 323	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   982: invokespecial 326	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView:<init>	(Landroid/content/Context;Ljava/util/List;Lcom/tencent/util/Pair;)V
    //   985: astore 5
    //   987: aload 5
    //   989: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   992: goto -504 -> 488
    //   995: new 328	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView
    //   998: dup
    //   999: aload_0
    //   1000: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1003: aload 7
    //   1005: iconst_1
    //   1006: invokespecial 329	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1009: astore 5
    //   1011: aload 5
    //   1013: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1016: goto -528 -> 488
    //   1019: iload_3
    //   1020: ifeq +24 -> 1044
    //   1023: aload 7
    //   1025: new 175	arvi
    //   1028: dup
    //   1029: aload_0
    //   1030: aload 8
    //   1032: iconst_1
    //   1033: iconst_1
    //   1034: iconst_1
    //   1035: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1038: invokeinterface 201 2 0
    //   1043: pop
    //   1044: new 331	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelPicTabView
    //   1047: dup
    //   1048: aload_0
    //   1049: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1052: aload 7
    //   1054: iconst_1
    //   1055: invokespecial 332	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelPicTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1058: astore 5
    //   1060: aload 5
    //   1062: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1065: goto -577 -> 488
    //   1068: new 334	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView
    //   1071: dup
    //   1072: aload_0
    //   1073: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1076: aload 7
    //   1078: iconst_1
    //   1079: invokespecial 335	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1082: astore 5
    //   1084: aload 5
    //   1086: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1089: goto -601 -> 488
    //   1092: new 312	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView
    //   1095: dup
    //   1096: aload_0
    //   1097: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1100: aload 7
    //   1102: new 314	com/tencent/util/Pair
    //   1105: dup
    //   1106: ldc_w 336
    //   1109: invokestatic 320	alud:a	(I)Ljava/lang/String;
    //   1112: iconst_3
    //   1113: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1116: invokespecial 323	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1119: invokespecial 326	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView:<init>	(Landroid/content/Context;Ljava/util/List;Lcom/tencent/util/Pair;)V
    //   1122: astore 5
    //   1124: aload 5
    //   1126: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1129: goto -641 -> 488
    //   1132: aload 7
    //   1134: new 175	arvi
    //   1137: dup
    //   1138: aload_0
    //   1139: invokestatic 208	arqx:a	()Larqx;
    //   1142: invokevirtual 338	arqx:c	()Ljava/lang/String;
    //   1145: iconst_1
    //   1146: iconst_0
    //   1147: iconst_0
    //   1148: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1151: invokeinterface 201 2 0
    //   1156: pop
    //   1157: aload 7
    //   1159: new 175	arvi
    //   1162: dup
    //   1163: aload_0
    //   1164: new 177	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   1171: invokestatic 208	arqx:a	()Larqx;
    //   1174: invokevirtual 210	arqx:b	()Ljava/lang/String;
    //   1177: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: ldc_w 340
    //   1183: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: iconst_1
    //   1190: iconst_0
    //   1191: iconst_0
    //   1192: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1195: invokeinterface 201 2 0
    //   1200: pop
    //   1201: new 312	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView
    //   1204: dup
    //   1205: aload_0
    //   1206: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1209: aload 7
    //   1211: new 314	com/tencent/util/Pair
    //   1214: dup
    //   1215: ldc_w 341
    //   1218: invokestatic 320	alud:a	(I)Ljava/lang/String;
    //   1221: bipush 11
    //   1223: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1226: invokespecial 323	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1229: invokespecial 326	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelFileTabView:<init>	(Landroid/content/Context;Ljava/util/List;Lcom/tencent/util/Pair;)V
    //   1232: astore 5
    //   1234: aload 5
    //   1236: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1239: goto -751 -> 488
    //   1242: new 343	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1245: dup
    //   1246: aload_0
    //   1247: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1250: iconst_3
    //   1251: aload 7
    //   1253: iconst_1
    //   1254: invokespecial 346	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1257: astore 5
    //   1259: aload 5
    //   1261: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1264: goto -776 -> 488
    //   1267: iload_3
    //   1268: ifeq +24 -> 1292
    //   1271: aload 7
    //   1273: new 175	arvi
    //   1276: dup
    //   1277: aload_0
    //   1278: aload 9
    //   1280: iconst_0
    //   1281: iconst_1
    //   1282: iconst_1
    //   1283: invokespecial 196	arvi:<init>	(Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView;Ljava/lang/String;ZZZ)V
    //   1286: invokeinterface 201 2 0
    //   1291: pop
    //   1292: new 348	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelMediaTabView
    //   1295: dup
    //   1296: aload_0
    //   1297: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1300: aload 7
    //   1302: iconst_1
    //   1303: invokespecial 349	com/tencent/mobileqq/filemanager/activity/delDownloadFile/QfileLocalFileDelMediaTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1306: astore 5
    //   1308: aload 5
    //   1310: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1313: goto -825 -> 488
    //   1316: new 343	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1319: dup
    //   1320: aload_0
    //   1321: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1324: iconst_1
    //   1325: aload 7
    //   1327: iconst_1
    //   1328: invokespecial 346	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1331: astore 5
    //   1333: aload 5
    //   1335: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1338: goto -850 -> 488
    //   1341: new 343	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1344: dup
    //   1345: aload_0
    //   1346: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1349: iconst_2
    //   1350: aload 7
    //   1352: iconst_1
    //   1353: invokespecial 346	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1356: astore 5
    //   1358: aload 5
    //   1360: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1363: goto -875 -> 488
    //   1366: new 351	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView
    //   1369: dup
    //   1370: aload_0
    //   1371: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1374: aload 7
    //   1376: iconst_1
    //   1377: invokespecial 352	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1380: astore 5
    //   1382: aload 5
    //   1384: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1387: goto -899 -> 488
    //   1390: new 354	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1393: dup
    //   1394: aload_0
    //   1395: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1398: ldc_w 356
    //   1401: aload_0
    //   1402: getfield 358	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1405: invokespecial 361	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1408: astore 5
    //   1410: aload 5
    //   1412: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1415: goto -927 -> 488
    //   1418: new 354	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1421: dup
    //   1422: aload_0
    //   1423: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1426: ldc_w 363
    //   1429: aload_0
    //   1430: getfield 358	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1433: invokespecial 361	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1436: astore 5
    //   1438: aload 5
    //   1440: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1443: goto -955 -> 488
    //   1446: new 354	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1449: dup
    //   1450: aload_0
    //   1451: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1454: ldc_w 365
    //   1457: aload_0
    //   1458: getfield 358	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1461: invokespecial 361	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1464: astore 5
    //   1466: aload 5
    //   1468: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1471: goto -983 -> 488
    //   1474: new 354	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1477: dup
    //   1478: aload_0
    //   1479: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1482: ldc_w 367
    //   1485: aload_0
    //   1486: getfield 358	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1489: invokespecial 361	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1492: astore 5
    //   1494: aload 5
    //   1496: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1499: goto -1011 -> 488
    //   1502: new 354	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView
    //   1505: dup
    //   1506: aload_0
    //   1507: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1510: ldc_w 369
    //   1513: aload_0
    //   1514: getfield 358	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_b_of_type_Int	I
    //   1517: invokespecial 361	com/tencent/mobileqq/filemanager/activity/cloudfile/QfileCloudFileTabView:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1520: astore 5
    //   1522: aload 5
    //   1524: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1527: goto -1039 -> 488
    //   1530: new 307	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView
    //   1533: dup
    //   1534: aload_0
    //   1535: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1538: aload 6
    //   1540: iconst_0
    //   1541: invokespecial 310	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileAppTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1544: astore 5
    //   1546: aload 5
    //   1548: iconst_1
    //   1549: invokevirtual 372	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1552: aload 5
    //   1554: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1557: goto -1069 -> 488
    //   1560: new 343	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView
    //   1563: dup
    //   1564: aload_0
    //   1565: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1568: iconst_3
    //   1569: aload 6
    //   1571: iconst_0
    //   1572: invokespecial 346	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileMediaTabView:<init>	(Landroid/content/Context;ILjava/util/List;Z)V
    //   1575: astore 5
    //   1577: aload 5
    //   1579: iconst_1
    //   1580: invokevirtual 372	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1583: aload 5
    //   1585: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1588: goto -1100 -> 488
    //   1591: new 328	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView
    //   1594: dup
    //   1595: aload_0
    //   1596: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1599: aload 6
    //   1601: iconst_0
    //   1602: invokespecial 329	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFilePicTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1605: astore 5
    //   1607: aload 5
    //   1609: iconst_1
    //   1610: invokevirtual 372	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1613: aload 5
    //   1615: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1618: goto -1130 -> 488
    //   1621: new 334	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView
    //   1624: dup
    //   1625: aload_0
    //   1626: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1629: aload 6
    //   1631: iconst_0
    //   1632: invokespecial 335	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileDocTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1635: astore 5
    //   1637: aload 5
    //   1639: iconst_1
    //   1640: invokevirtual 372	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1643: aload 5
    //   1645: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1648: goto -1160 -> 488
    //   1651: new 351	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView
    //   1654: dup
    //   1655: aload_0
    //   1656: getfield 36	com/tencent/mobileqq/filemanager/widget/QfileTabBarView:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity	Lcom/tencent/mobileqq/filemanager/activity/BaseFileAssistantActivity;
    //   1659: aload 6
    //   1661: iconst_0
    //   1662: invokespecial 352	com/tencent/mobileqq/filemanager/activity/localfile/QfileLocalFileOtherTabView:<init>	(Landroid/content/Context;Ljava/util/List;Z)V
    //   1665: astore 5
    //   1667: aload 5
    //   1669: iconst_1
    //   1670: invokevirtual 372	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:setFromWeiXin	(Z)V
    //   1673: aload 5
    //   1675: invokevirtual 279	com/tencent/mobileqq/filemanager/activity/fileassistant/QfileBaseTabView:b	()V
    //   1678: goto -1190 -> 488
    //   1681: astore 6
    //   1683: goto -1123 -> 560
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1686	0	this	QfileTabBarView
    //   0	1686	1	paramInt	int
    //   41	554	2	i	int
    //   178	1090	3	j	int
    //   200	686	4	k	int
    //   14	539	5	localQfileBaseTabView	QfileBaseTabView
    //   555	1	5	localException1	java.lang.Exception
    //   558	1116	5	localObject	java.lang.Object
    //   49	1611	6	localArrayList1	ArrayList
    //   1681	1	6	localException2	java.lang.Exception
    //   138	1237	7	localArrayList2	ArrayList
    //   236	795	8	str1	String
    //   241	1038	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	16	555	java/lang/Exception
    //   24	42	1681	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */