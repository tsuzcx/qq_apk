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
  private JSONObject a;
  private String b;
  private final String c;
  private boolean d;
  private IColorNoteController e;
  private final ColorNote f;
  private ColorNote g;
  private ViolaColorNote.OnEnterMiniAioEvent h;
  private boolean i;
  private final boolean j;
  
  public ViolaColorNote(String paramString)
  {
    this.c = paramString;
    ColorNote.Builder localBuilder = new ColorNote.Builder().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("viola:");
    localStringBuilder.append(paramString);
    this.f = localBuilder.a(localStringBuilder.toString()).b("defaultTitle").c("defaultSubTitle").d("https://default").a();
    paramString = Aladdin.getConfig(417);
    boolean bool = false;
    if (paramString.getIntegerFromString("open_auto_color_ball", 0) == 1) {
      bool = true;
    }
    this.j = bool;
    if (this.j)
    {
      this.g = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).createRecentColorNote(this.f);
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
    if (this.a == null) {
      this.a = new JSONObject();
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        this.a.put(str, paramJSONObject.opt(str));
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ViolaColorNote", 1, localJSONException.getMessage());
      }
    }
  }
  
  private void e()
  {
    JSONObject localJSONObject = this.a;
    if (localJSONObject != null)
    {
      Object localObject = this.f;
      if (localObject == null) {
        return;
      }
      try
      {
        ((ColorNote)localObject).mMainTitle = localJSONObject.optString("title");
        this.f.mSubTitle = this.a.optString("subTitle");
        this.f.mPicUrl = this.a.optString("imageUrl");
        this.a.put("param", this.b).put("url", this.c).put("useTransParentFragment", this.d);
        this.f.mReserve = this.a.toString().getBytes();
        this.e.updateColorNote(this.f);
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
  
  private void f()
  {
    if (this.f != null)
    {
      if (this.e == null) {
        return;
      }
      c();
      e();
      this.e.addToRecentNote();
      if (!this.e.shouldDisplayColorNote()) {
        QLog.e("ViolaColorNote", 1, "ColorNote Not Ready");
      }
    }
  }
  
  public ColorNote a()
  {
    return this.f;
  }
  
  public ViolaColorNote a(IColorNoteController paramIColorNoteController)
  {
    this.e = paramIColorNoteController;
    return this;
  }
  
  public ViolaColorNote a(ViolaColorNote.OnEnterMiniAioEvent paramOnEnterMiniAioEvent)
  {
    this.h = paramOnEnterMiniAioEvent;
    return this;
  }
  
  public ViolaColorNote a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public ViolaColorNote a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public void a(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    if (1 == paramInt) {
      e();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    c(paramJSONObject);
    paramJSONObject = this.e;
    if (paramJSONObject != null) {
      paramJSONObject.enableSwipe();
    }
  }
  
  public void b()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    if (((IColorNoteController)localObject).isColorNoteExist()) {
      e();
    }
    localObject = this.g;
    if ((localObject != null) && (this.e.isColorNoteExist((ColorNote)localObject)))
    {
      e();
      this.e.addToRecentNote();
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public void c()
  {
    JSONObject localJSONObject = this.a;
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
  
  public void d()
  {
    if (this.i) {
      f();
    }
    if (this.j) {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
    this.i = false;
    IColorNoteController localIColorNoteController = this.e;
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
      this.i = true;
      paramSimpleBaseEvent = this.h;
      if (paramSimpleBaseEvent != null) {
        paramSimpleBaseEvent.p();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaColorNote
 * JD-Core Version:    0.7.0.1
 */