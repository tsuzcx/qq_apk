package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import ayzr;
import ayzs;
import ayzt;
import ayzu;
import ayzv;
import ayzw;
import azaa;
import azad;
import azae;
import azaj;
import azak;
import azao;
import azar;
import azax;
import azba;
import azbc;
import azbi;
import azbo;
import azbq;
import beex;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditor
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private View jdField_a_of_type_AndroidViewView;
  private ayzs jdField_a_of_type_Ayzs;
  private ayzt jdField_a_of_type_Ayzt;
  private ayzu jdField_a_of_type_Ayzu;
  public ayzw a;
  private azaj jdField_a_of_type_Azaj;
  azax jdField_a_of_type_Azax = new ayzr(this);
  private azba jdField_a_of_type_Azba;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public XMediaEditor(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new LinearLayoutManager(paramContext);
    addItemDecoration(new ayzv(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Azba = new azba(this, paramContext);
    this.jdField_a_of_type_Azba.a(this.jdField_a_of_type_Azax);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Azba);
    paramAttributeSet.put(0, new azbi(this, paramContext).a(this.jdField_a_of_type_Azax));
    paramAttributeSet.put(3, new azar(this, paramContext).a(this.jdField_a_of_type_Azax));
    paramAttributeSet.put(1, new azbc(this).a(this.jdField_a_of_type_Azax));
    paramAttributeSet.put(2, new azbq(this).a(this.jdField_a_of_type_Azax));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Azax));
    paramAttributeSet.put(7, new azao(this, paramContext).a(this.jdField_a_of_type_Azax));
    this.jdField_a_of_type_Ayzw = new ayzw(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Ayzw);
    setDefaultContent();
  }
  
  private <T extends View> T a(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return null;
        if (paramClass.isInstance(paramView)) {
          return (View)paramClass.cast(paramView);
        }
      } while (!(paramView instanceof ViewGroup));
      paramView = (ViewGroup)paramView;
      i = paramView.getChildCount();
    } while (i <= 0);
    return a(paramClass, paramView.getChildAt(i - 1));
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_Ayzw.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Ayzw.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Ayzw.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<azak> a()
  {
    return this.jdField_a_of_type_Ayzw.a();
  }
  
  public ArrayList<azaa> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Ayzw.getItemCount())
    {
      if (this.jdField_a_of_type_Ayzw.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Ayzw.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
    azbo localazbo = (azbo)findViewHolderForAdapterPosition(this.jdField_a_of_type_Azaj.jdField_c_of_type_Int);
    if (localazbo != null)
    {
      localazbo.a.setFocusable(true);
      localazbo.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localazbo));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Ayzw.b(0);
      this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
      this.jdField_a_of_type_Azax.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Ayzw.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Ayzw.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Ayzw.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof azaj))
        {
          if (this.jdField_a_of_type_Azaj != null) {
            this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Azaj = ((azaj)localObject2);
          this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Ayzw.b(paramInt);
        this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
        this.jdField_a_of_type_Azax.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof azaj)) || (!(localObject2 instanceof azaj)))
      {
        this.jdField_a_of_type_Ayzw.b(paramInt);
        this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
        this.jdField_a_of_type_Azax.a(null, false);
        return;
      }
      localObject1 = (azaj)localObject1;
      localObject2 = (azaj)localObject2;
      ((azaj)localObject2).jdField_a_of_type_Int = ((azaj)localObject2).jdField_a_of_type_JavaLangString.length();
      azbo localazbo = (azbo)findViewHolderForAdapterPosition(((azaj)localObject2).jdField_c_of_type_Int);
      if (localazbo != null) {
        localazbo.a.setSelection(((azaj)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((azaj)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Azaj != null) {
          this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Azaj = ((azaj)localObject2);
        this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ayzw.b(paramInt + 1);
        this.jdField_a_of_type_Ayzw.b(paramInt);
        this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
        this.jdField_a_of_type_Azax.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((azaj)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((azaj)localObject2).jdField_a_of_type_JavaLangString = ((azaj)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((azaj)localObject2).jdField_a_of_type_JavaLangString += ((azaj)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Ayzw.a(paramInt, paramString);
    this.jdField_a_of_type_Azax.a(null, false);
  }
  
  public void a(azaa paramazaa)
  {
    if (paramazaa == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Ayzw.getItemCount() == 0)
    {
      if ((paramazaa instanceof azaj))
      {
        this.jdField_a_of_type_Ayzw.a(paramazaa);
        this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
        this.jdField_a_of_type_Azaj = ((azaj)paramazaa);
        this.jdField_a_of_type_Azaj.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new azaj("");
      localObject2 = new azaj("");
      this.jdField_a_of_type_Ayzw.a((azaa)localObject1);
      this.jdField_a_of_type_Ayzw.a(paramazaa);
      this.jdField_a_of_type_Ayzw.a((azaa)localObject2);
      this.jdField_a_of_type_Azaj = ((azaj)localObject2);
      this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Azaj.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
      this.jdField_a_of_type_Azax.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Azaj.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Azaj == null)
    {
      localObject1 = this.jdField_a_of_type_Ayzw.a(this.jdField_a_of_type_Ayzw.getItemCount() - 1);
      if ((localObject1 instanceof azaj))
      {
        this.jdField_a_of_type_Azaj = ((azaj)localObject1);
        this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Azaj.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Azaj.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Azaj.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Azaj.jdField_a_of_type_Int;
      localObject1 = (azbo)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label615;
      }
      i = ((azbo)localObject1).a.getSelectionStart();
    }
    label313:
    label615:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Azaj.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
          if (!(paramazaa instanceof azaj)) {
            break label519;
          }
          paramazaa = (azaj)paramazaa;
          this.jdField_a_of_type_Azaj.b((String)localObject2 + paramazaa.jdField_a_of_type_JavaLangString + (String)localObject1);
          localObject1 = this.jdField_a_of_type_Azaj;
          ((azaj)localObject1).jdField_a_of_type_Int += paramazaa.jdField_a_of_type_JavaLangString.length();
        }
      }
      for (;;)
      {
        scrollToPosition(this.jdField_a_of_type_Azaj.jdField_c_of_type_Int);
        this.jdField_a_of_type_Azax.a(null, false);
        return;
        localObject1 = new azaj("");
        this.jdField_a_of_type_Azaj = ((azaj)localObject1);
        this.jdField_a_of_type_Azaj.jdField_c_of_type_Int = this.jdField_a_of_type_Ayzw.getItemCount();
        this.jdField_a_of_type_Ayzw.a((azaa)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Azaj.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        break label313;
        localObject2 = this.jdField_a_of_type_Azaj.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Azaj.jdField_a_of_type_JavaLangString.length() == i)
        {
          localObject1 = "";
          break label313;
        }
        localObject1 = this.jdField_a_of_type_Azaj.jdField_a_of_type_JavaLangString.substring(i);
        break label313;
        ((azaj)this.jdField_a_of_type_Ayzw.a(j)).b((String)localObject2);
        localObject1 = new azaj((String)localObject1);
        this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = false;
        ((azaj)localObject1).jdField_a_of_type_Boolean = true;
        ((azaj)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Azaj = ((azaj)localObject1);
        this.jdField_a_of_type_Ayzw.a(j + 1, (azaa)localObject1);
        this.jdField_a_of_type_Ayzw.a(j + 1, paramazaa);
        this.jdField_a_of_type_Azaj.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList<azak> paramArrayList)
  {
    this.jdField_a_of_type_Ayzw.a(paramArrayList);
  }
  
  public void a(List<azaa> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((azaa)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ayzw.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<azae> b()
  {
    return this.jdField_a_of_type_Ayzw.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Azaj.jdField_a_of_type_Boolean = false;
    azbo localazbo = (azbo)findViewHolderForAdapterPosition(this.jdField_a_of_type_Azaj.jdField_c_of_type_Int);
    if (localazbo != null)
    {
      localazbo.a.setFocusable(false);
      localazbo.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localazbo));
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    setDefaultContent();
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return (this.jdField_a_of_type_Boolean) && (super.canScrollVertically(paramInt));
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Ayzw.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Azba.a(null);
    if (this.jdField_a_of_type_Ayzw.b())
    {
      this.jdField_a_of_type_Ayzw.b(0);
      this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Ayzw.a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int != 2147483647) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (d() == 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      EditText localEditText = (EditText)a(EditText.class, this);
      if (localEditText != null)
      {
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        float f = paramMotionEvent.getRawY();
        if (arrayOfInt[1] <= f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("XMediaEditor", 2, "Oops! found et");
          }
          if (!localEditText.isFocused())
          {
            localEditText.setFocusable(true);
            localEditText.setFocusableInTouchMode(true);
            localEditText.requestFocus();
          }
          beex.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(ayzs paramayzs)
  {
    this.jdField_a_of_type_Ayzs = paramayzs;
  }
  
  public void setContentLengthChangeListener(ayzt paramayzt)
  {
    this.jdField_a_of_type_Ayzt = paramayzt;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Ayzw.a(new JSONArray(paramString));
      this.jdField_a_of_type_Azax.a(null, false);
      int i = this.jdField_a_of_type_Ayzw.b();
      this.jdField_a_of_type_Azax.a(this.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Int = i;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDefaultContent()
  {
    setData("[" + new azaj("").toString() + "]");
    this.jdField_a_of_type_Azaj = ((azaj)this.jdField_a_of_type_Ayzw.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(ayzu paramayzu)
  {
    this.jdField_a_of_type_Ayzu = paramayzu;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Azba.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Ayzw.b())
    {
      this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Ayzw.a(0, new azad());
    this.jdField_a_of_type_Ayzw.notifyDataSetChanged();
  }
  
  public void setHint(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLeftRightPadding(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShowType(int paramInt)
  {
    this.jdField_a_of_type_Ayzw.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */