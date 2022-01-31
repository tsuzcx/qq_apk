package com.tencent.mobileqq.nearby.now.send;

import aeud;
import aeue;
import aeuf;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.NowPublishParam;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LogUtil;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;

public class PublishManager
  implements View.OnClickListener, IEventReceiver
{
  public static Object a;
  public static HashMap a;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  EditVideoParams jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams;
  public PublishParam a;
  public QQAppInterface a;
  private LocationInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  public EditVideoUi a;
  ImageFeedsUploader jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader;
  VideoFeedsManager jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager;
  private StartLiveTopicLabelListView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public String a;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private LocationInfo jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  PublishManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (!str.equals("+标签")))
        {
          ((JSONArray)localObject).put(i, str);
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0) {
        return null;
      }
      localObject = ((JSONArray)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PublishManager", 1, localJSONException, new Object[0]);
    }
    return null;
  }
  
  public static List a()
  {
    Object localObject = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((QQStoryEntityManagerFactory)localObject).verifyAuthentication();
    List localList1 = a(((QQStoryEntityManagerFactory)localObject).createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "businessId=? and (publishState=? or publishState=?)", new String[] { "9", "2", "3" });
    if ((localList1 == null) || (localList1.size() == 0)) {
      return localList1;
    }
    localObject = jdField_a_of_type_JavaLangObject;
    int j = 0;
    label204:
    label207:
    label214:
    for (;;)
    {
      try
      {
        if (j < localList1.size())
        {
          if (((PublishVideoEntry)localList1.get(j)).publishState == 2) {
            break label207;
          }
          Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!((PublishVideoEntry)localList1.get(j)).fakeVid.equals(str)) {
              break label204;
            }
            i = 1;
            break label214;
          }
          if (i != 0) {
            break label207;
          }
          ((PublishVideoEntry)localList1.get(j)).publishState = 2;
        }
      }
      finally {}
      return localList2;
      break label214;
      j += 1;
    }
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return;
    }
    FileUtils.a(paramPublishVideoEntry.backgroundMusicPath, false);
    FileUtils.a(paramPublishVideoEntry.doodlePath, false);
    FileUtils.a(paramPublishVideoEntry.mAudioFilePath, false);
    FileUtils.a(paramPublishVideoEntry.mIFrameVideoPath, false);
    FileUtils.a(paramPublishVideoEntry.mLocalRawPicPath, false);
    FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir, false);
    FileUtils.a(paramPublishVideoEntry.thumbPath, false);
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    paramPublishVideoEntry.setStatus(1001);
    return QQStoryContext.a().a().createEntityManager().a(paramPublishVideoEntry);
  }
  
  public static boolean a(String paramString)
  {
    QQStoryEntityManagerFactory localQQStoryEntityManagerFactory = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localQQStoryEntityManagerFactory.verifyAuthentication();
    paramString = a(localQQStoryEntityManagerFactory.createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { "" + paramString });
    if ((paramString == null) || (paramString.size() < 1))
    {
      QLog.i("PublishManager", 1, "removeUnPublishState() called with: list = [" + paramString + "]");
      return false;
    }
    paramString = (PublishVideoEntry)paramString.get(0);
    paramString.publishState = 0;
    boolean bool = a(paramString);
    if (bool) {
      a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PublishManager", 2, "removeUnPublishState() called with: flag = [" + bool + "]");
    }
    return bool;
  }
  
  public static List b()
  {
    Object localObject = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((QQStoryEntityManagerFactory)localObject).verifyAuthentication();
    localObject = a(((QQStoryEntityManagerFactory)localObject).createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "businessId=? and publishState=?", new String[] { "9", "2" });
    if ((localObject != null) && (((List)localObject).size() == 0)) {}
    return localObject;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramString);
      }
      if ((this.jdField_a_of_type_JavaUtilLinkedList.size() <= 2) && (!this.jdField_a_of_type_JavaUtilLinkedList.contains("+标签"))) {
        this.jdField_a_of_type_JavaUtilLinkedList.addLast("+标签");
      }
    } while ((this.jdField_a_of_type_JavaUtilLinkedList.size() <= 3) || (!this.jdField_a_of_type_JavaUtilLinkedList.contains("+标签")));
    this.jdField_a_of_type_JavaUtilLinkedList.remove("+标签");
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a(0, null, 0, 0);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a(0, null, 0, 0);
      return false;
    }
    Object localObject = new NowVideoReporter().h("video_public").i("exp_cancelbox");
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      ((NowVideoReporter)localObject).a(i).d(this.jdField_b_of_type_JavaLangString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
      ((QQCustomDialog)localObject).setTitle("确认退出此次编辑?");
      ((QQCustomDialog)localObject).setPositiveButton("确定", new aeue(this));
      ((QQCustomDialog)localObject).setNegativeButton("取消", new aeuf(this));
      ((QQCustomDialog)localObject).show();
      return true;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0) {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast("+标签");
    }
    if (QLog.isColorLevel()) {
      QLog.i("PublishManager", 2, "refreshTopicList mTopicList.size()  =" + this.jdField_a_of_type_JavaUtilLinkedList.size());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView.setData(this.jdField_a_of_type_JavaUtilLinkedList);
  }
  
  public LocationInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    String str = paramIntent.getStringExtra("topic");
    if (TextUtils.isEmpty(paramIntent.getStringExtra("topic"))) {
      return;
    }
    try
    {
      paramIntent = new JSONArray(str);
      paramInt1 = paramIntent.length() - 1;
      while (paramInt1 >= 0)
      {
        b(paramIntent.getString(paramInt1));
        paramInt1 -= 1;
      }
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
      d();
    }
  }
  
  public void a(LocationInfo paramLocationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = paramLocationInfo;
  }
  
  void a(EditVideoUi paramEditVideoUi, EditVideoParams paramEditVideoParams)
  {
    if (paramEditVideoUi == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi != paramEditVideoUi) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi = paramEditVideoUi;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("PublishManager", 2, "duplicate attachUiAndParams ui=" + paramEditVideoUi + ", params=" + paramEditVideoParams);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return b();
  }
  
  public LocationInfo b()
  {
    LogUtil.d("PublishManager", "getSavedLocation()");
    Object localObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "nearby_now_small_video_location");
    if ((localObject != null) && ((localObject instanceof LocationInfo))) {
      return (LocationInfo)localObject;
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().findViewById(2131370600));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().findViewById(2131370601));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().findViewById(2131370603));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView = ((StartLiveTopicLabelListView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().findViewById(2131370607));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView.setItemResId(2130842825);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView.setItemTextColor(-5288197);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView.setItemAddLabelResId(2130842823);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView.setItemAddLabelTextColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView.a(new aeud(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().getIntent().hasExtra("topic")) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().getIntent().getStringExtra("topic")))) {
      b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().getIntent().getStringExtra("topic"));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam = ((PublishParam)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().getIntent().getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString));
    d();
  }
  
  public void b(LocationInfo paramLocationInfo)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    LogUtil.d("PublishManager", "saveLocation()" + arrayOfStackTraceElement[1] + "  info:" + paramLocationInfo.toString());
    FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "nearby_now_small_video_location", paramLocationInfo);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c() {}
  
  public boolean isValidate()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    int i = paramView.getId();
    if (i == 2131370600) {
      b();
    }
    while ((i == 2131370605) || (i == 2131370606) || (i != 2131370601)) {
      return;
    }
    paramView = new NowVideoReporter().h("video_public").i("clk_public");
    if (this.jdField_b_of_type_Boolean) {}
    for (i = 2;; i = 1)
    {
      paramView.a(i).d(this.jdField_b_of_type_JavaLangString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "网络未连接，无法上传！", 0).a();
      return;
    }
    paramView = new StringBuilder();
    paramView.append(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    if (this.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!((String)localObject2).equals("+标签")) {
          paramView.append("_" + (String)localObject2);
        }
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.f)) {
      paramView.append("_" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.f);
    }
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
    {
      localObject1 = new NowVideoReporter().h("video_public").i("text");
      if (!this.jdField_b_of_type_Boolean) {
        break label414;
      }
    }
    label414:
    for (i = j;; i = 1)
    {
      ((NowVideoReporter)localObject1).a(i).d(this.jdField_b_of_type_JavaLangString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.h == 0) {
        break label725;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader == null) || (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader.jdField_a_of_type_Boolean)) {
        break;
      }
      QLog.d("PublishManager", 1, "upload stop , is uploading!");
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, "正在上传中！", 0).a();
      return;
    }
    Object localObject1 = new PicFeedUploadInfo();
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo != null)
    {
      ((PicFeedUploadInfo)localObject1).lat = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getLat();
      ((PicFeedUploadInfo)localObject1).lng = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getLng();
      ((PicFeedUploadInfo)localObject1).city = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getAddress();
    }
    String str;
    for (;;)
    {
      ((PicFeedUploadInfo)localObject1).desc = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
        break;
      }
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (!str.equals("+标签")) {
          ((PicFeedUploadInfo)localObject1).topic.add(str);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo != null)
      {
        ((PicFeedUploadInfo)localObject1).lat = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getLat();
        ((PicFeedUploadInfo)localObject1).lng = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getLng();
        ((PicFeedUploadInfo)localObject1).city = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getCity();
      }
      else
      {
        a();
      }
    }
    Object localObject2 = new LocalMediaInfo();
    ((LocalMediaInfo)localObject2).jdField_a_of_type_Long = 0L;
    ((LocalMediaInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.jdField_b_of_type_JavaLangString;
    ((LocalMediaInfo)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.c;
    ((LocalMediaInfo)localObject2).c = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.jdField_a_of_type_Int;
    ((LocalMediaInfo)localObject2).d = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.jdField_b_of_type_Int;
    ((PicFeedUploadInfo)localObject1).photoInfo.add(localObject2);
    ((PicFeedUploadInfo)localObject1).locationInfo = a();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader = new ImageFeedsUploader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PicFeedUploadInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.toString());
    return;
    label725:
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.jdField_a_of_type_Boolean))
    {
      QLog.d("PublishManager", 1, "upload stop , is uploading!");
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, "正在上传中！", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager = new VideoFeedsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi, this);
    localObject1 = new NowPublishParam(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
    ((NowPublishParam)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    ((NowPublishParam)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
    ((NowPublishParam)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (!str.equals("+标签")) {
          ((NowPublishParam)localObject1).jdField_a_of_type_JavaUtilList.add(str);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsManager.a((NowPublishParam)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.PublishManager
 * JD-Core Version:    0.7.0.1
 */