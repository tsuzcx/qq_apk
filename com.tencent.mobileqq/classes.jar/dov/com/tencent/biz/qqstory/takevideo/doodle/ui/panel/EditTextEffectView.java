package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import aumj;
import bogd;
import boiu;
import bpca;
import bpcb;
import bpcc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import ykv;

public class EditTextEffectView
  extends RecyclerView
  implements Handler.Callback
{
  public static final int a;
  public static final int b;
  public static final int c;
  public Handler a;
  public LinearLayoutManager a;
  aumj jdField_a_of_type_Aumj;
  boiu jdField_a_of_type_Boiu = new bpca(this);
  bpcb jdField_a_of_type_Bpcb = null;
  public Vector<DynamicTextConfigManager.DynamicTextConfigBean> a;
  public boolean a;
  public int d = -1;
  private int e;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = AIOUtils.dp2px(5.0F, localResources);
    jdField_a_of_type_Int = AIOUtils.dp2px(5.0F, localResources);
    c = AIOUtils.dp2px(3.0F, localResources);
  }
  
  public EditTextEffectView(Context paramContext, aumj paramaumj)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Aumj = paramaumj;
    setClipToPadding(false);
    b();
    a();
    setClipChildren(false);
  }
  
  private List<DynamicTextConfigManager.DynamicTextConfigBean> a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next()).text_id >= 29) {
        localIterator.remove();
      }
    }
    while (paramList.size() > 29) {
      paramList.remove(paramList.size() - 1);
    }
    return paramList;
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bpcb != null) && (this.jdField_a_of_type_Bpcb.a != null))
    {
      int j = this.jdField_a_of_type_Bpcb.a.size();
      int i = 0;
      while (i < j)
      {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_Bpcb.a.get(i)).text_id == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt)
  {
    if (this.jdField_a_of_type_Bpcb.a == null) {
      return null;
    }
    return (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_Bpcb.a.get(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "loadData");
    }
    DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)bogd.a(7);
    if (!localDynamicTextConfigManager.a()) {
      localDynamicTextConfigManager.a();
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
    ArrayList localArrayList = localDynamicTextConfigManager.a();
    localDynamicTextConfigManager.a(localArrayList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_JavaUtilVector.addAll(a(localArrayList));
    this.jdField_a_of_type_Bpcb.a(this.jdField_a_of_type_JavaUtilVector);
    this.jdField_a_of_type_Bpcb.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((this.jdField_a_of_type_Bpcb.a != null) && (paramInt < this.jdField_a_of_type_Bpcb.a.size()))
    {
      this.d = ((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_Bpcb.a.get(paramInt)).text_id;
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getChildCount();
      int i = 0;
      label65:
      bpcc localbpcc;
      if (i < j)
      {
        localbpcc = (bpcc)getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getChildAt(i));
        if (localbpcc.jdField_a_of_type_Int == paramInt) {
          break label109;
        }
        localbpcc.b(false);
      }
      for (;;)
      {
        i += 1;
        break label65;
        break;
        label109:
        localbpcc.b(true);
        ykv.a("video_edit_new", "text_element", this.e, 0, new String[] { "0", String.valueOf(this.d) });
      }
    }
    QLog.e("EditTextEffectView", 1, "select position = " + paramInt + " no item");
  }
  
  @TargetApi(9)
  public void b()
  {
    setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Bpcb = new bpcb(this, this.jdField_a_of_type_Aumj);
    setAdapter(this.jdField_a_of_type_Bpcb);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    this.jdField_a_of_type_Boiu = new boiu();
    localAppRuntime.registObserver(this.jdField_a_of_type_Boiu);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseApplicationImpl.getApplication().waitAppRuntime(null).unRegistObserver(this.jdField_a_of_type_Boiu);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("EditTextEffectView", 2, "exittext panel visible");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("EditTextEffectView", 2, "exittext panel gone");
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOpIn(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView
 * JD-Core Version:    0.7.0.1
 */