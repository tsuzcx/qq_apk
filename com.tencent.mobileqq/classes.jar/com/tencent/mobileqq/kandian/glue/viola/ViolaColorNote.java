package com.tencent.mobileqq.kandian.glue.viola;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.miniaio.MiniPieJumpToAioEvent;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaColorNote
  implements SimpleEventReceiver<MiniPieJumpToAioEvent>
{
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private final ColorNote jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  private ViolaColorNote.OnEnterMiniAioEvent jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote$OnEnterMiniAioEvent;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private ColorNote jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final boolean c;
  
  public ViolaColorNote(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    ColorNote.Builder localBuilder = new ColorNote.Builder().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("viola:");
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = localBuilder.a(localStringBuilder.toString()).b("defaultTitle").c("defaultSubTitle").d("https://default").a();
    paramString = Aladdin.getConfig(417);
    boolean bool = false;
    if (paramString.getIntegerFromString("open_auto_color_ball", 0) == 1) {
      bool = true;
    }
    this.c = bool;
    if (this.c)
    {
      this.jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).createRecentColorNote(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
      SimpleEventBus.getInstance().registerReceiver(this);
    }
  }
  
  public static JSONObject a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return new JSONObject();
    }
    try
    {
      paramColorNote = new JSONObject(new String(paramColorNote.getReserve()));
      return paramColorNote;
    }
    catch (Exception paramColorNote)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getViolaColorNoteData]: ");
      localStringBuilder.append(paramColorNote.getMessage());
      QLog.d("ViolaColorNote", 1, localStringBuilder.toString());
    }
    return new JSONObject();
  }
  
  public static JSONObject b(ColorNote paramColorNote)
  {
    return a(paramColorNote).optJSONObject("report");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(str, paramJSONObject.opt(str));
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ViolaColorNote", 1, localJSONException.getMessage());
      }
    }
  }
  
  private void d()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
      if (localObject == null) {
        return;
      }
      try
      {
        ((ColorNote)localObject).mMainTitle = localJSONObject.optString("title");
        this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mSubTitle = this.jdField_a_of_type_OrgJsonJSONObject.optString("subTitle");
        this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mPicUrl = this.jdField_a_of_type_OrgJsonJSONObject.optString("imageUrl");
        this.jdField_a_of_type_OrgJsonJSONObject.put("param", this.jdField_a_of_type_JavaLangString).put("url", this.jdField_b_of_type_JavaLangString).put("useTransParentFragment", this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mReserve = this.jdField_a_of_type_OrgJsonJSONObject.toString().getBytes();
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.updateColorNote(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
        return;
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[setColorBallData]: ");
        ((StringBuilder)localObject).append(localException.getMessage());
        QLog.e("ViolaColorNote", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController == null) {
        return;
      }
      b();
      d();
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addToRecentNote();
      if (!this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.shouldDisplayColorNote()) {
        QLog.e("ViolaColorNote", 1, "ColorNote Not Ready");
      }
    }
  }
  
  public ColorNote a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  }
  
  public ViolaColorNote a(IColorNoteController paramIColorNoteController)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = paramIColorNoteController;
    return this;
  }
  
  public ViolaColorNote a(ViolaColorNote.OnEnterMiniAioEvent paramOnEnterMiniAioEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote$OnEnterMiniAioEvent = paramOnEnterMiniAioEvent;
    return this;
  }
  
  public ViolaColorNote a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ViolaColorNote a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject == null) {
      return;
    }
    if (((IColorNoteController)localObject).isColorNoteExist()) {
      d();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.isColorNoteExist((ColorNote)localObject)))
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addToRecentNote();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController == null) {
      return;
    }
    if (1 == paramInt) {
      d();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    c(paramJSONObject);
    paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (paramJSONObject != null) {
      paramJSONObject.enableSwipe();
    }
  }
  
  public void b()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject == null) {
      return;
    }
    localJSONObject = localJSONObject.optJSONObject("report");
    if (localJSONObject == null) {
      return;
    }
    try
    {
      localJSONObject.put("add_way", 3);
      return;
    }
    catch (JSONException localJSONException)
    {
      label32:
      break label32;
    }
    QLog.e("ViolaColorNote", 1, "changeAddWayToMiniAio error");
  }
  
  public void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      e();
    }
    if (this.c) {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
    this.jdField_b_of_type_Boolean = false;
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onDestroy();
    }
  }
  
  public ArrayList<Class<MiniPieJumpToAioEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniPieJumpToAioEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof MiniPieJumpToAioEvent))
    {
      this.jdField_b_of_type_Boolean = true;
      paramSimpleBaseEvent = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaColorNote$OnEnterMiniAioEvent;
      if (paramSimpleBaseEvent != null) {
        paramSimpleBaseEvent.j();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote
 * JD-Core Version:    0.7.0.1
 */