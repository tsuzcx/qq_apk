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
import bgdx;
import bgdy;
import bgdz;
import bgea;
import bgeb;
import bgec;
import bgeg;
import bgeh;
import bgej;
import bgek;
import bgel;
import bgep;
import bgeq;
import bgeu;
import bgex;
import bgfd;
import bgfg;
import bgfi;
import bgfo;
import bgfu;
import bgfw;
import blgx;
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
  private bgdy jdField_a_of_type_Bgdy;
  private bgdz jdField_a_of_type_Bgdz;
  private bgea jdField_a_of_type_Bgea;
  public bgec a;
  private bgep jdField_a_of_type_Bgep;
  bgfd jdField_a_of_type_Bgfd = new bgdx(this);
  private bgfg jdField_a_of_type_Bgfg;
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
    addItemDecoration(new bgeb(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Bgfg = new bgfg(this, paramContext);
    this.jdField_a_of_type_Bgfg.a(this.jdField_a_of_type_Bgfd);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Bgfg);
    paramAttributeSet.put(0, new bgfo(this, paramContext).a(this.jdField_a_of_type_Bgfd));
    paramAttributeSet.put(3, new bgex(this, paramContext).a(this.jdField_a_of_type_Bgfd));
    paramAttributeSet.put(1, new bgfi(this).a(this.jdField_a_of_type_Bgfd));
    paramAttributeSet.put(2, new bgfw(this).a(this.jdField_a_of_type_Bgfd));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Bgfd));
    paramAttributeSet.put(7, new bgeu(this, paramContext).a(this.jdField_a_of_type_Bgfd));
    this.jdField_a_of_type_Bgec = new bgec(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Bgec);
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
    for (int j = 0; i < this.jdField_a_of_type_Bgec.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Bgec.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bgec.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<bgeq> a()
  {
    return this.jdField_a_of_type_Bgec.a();
  }
  
  public ArrayList<bgeg> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bgec.getItemCount())
    {
      if (this.jdField_a_of_type_Bgec.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Bgec.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
    bgfu localbgfu = (bgfu)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bgep.jdField_c_of_type_Int);
    if (localbgfu != null)
    {
      localbgfu.a.setFocusable(true);
      localbgfu.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbgfu));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Bgec.b(0);
      this.jdField_a_of_type_Bgec.notifyDataSetChanged();
      this.jdField_a_of_type_Bgfd.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Bgec.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Bgec.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Bgec.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof bgep))
        {
          if (this.jdField_a_of_type_Bgep != null) {
            this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Bgep = ((bgep)localObject2);
          this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Bgec.b(paramInt);
        this.jdField_a_of_type_Bgec.notifyDataSetChanged();
        this.jdField_a_of_type_Bgfd.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof bgep)) || (!(localObject2 instanceof bgep)))
      {
        this.jdField_a_of_type_Bgec.b(paramInt);
        this.jdField_a_of_type_Bgec.notifyDataSetChanged();
        this.jdField_a_of_type_Bgfd.a(null, false);
        return;
      }
      localObject1 = (bgep)localObject1;
      localObject2 = (bgep)localObject2;
      ((bgep)localObject2).jdField_a_of_type_Int = ((bgep)localObject2).jdField_a_of_type_JavaLangString.length();
      bgfu localbgfu = (bgfu)findViewHolderForAdapterPosition(((bgep)localObject2).jdField_c_of_type_Int);
      if (localbgfu != null) {
        localbgfu.a.setSelection(((bgep)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((bgep)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Bgep != null) {
          this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Bgep = ((bgep)localObject2);
        this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bgec.b(paramInt + 1);
        this.jdField_a_of_type_Bgec.b(paramInt);
        this.jdField_a_of_type_Bgec.notifyDataSetChanged();
        this.jdField_a_of_type_Bgfd.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((bgep)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((bgep)localObject2).jdField_a_of_type_JavaLangString = ((bgep)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((bgep)localObject2).jdField_a_of_type_JavaLangString += ((bgep)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Bgec.a(paramInt, paramString);
    this.jdField_a_of_type_Bgfd.a(null, false);
  }
  
  public void a(bgeg parambgeg)
  {
    if (parambgeg == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Bgec.getItemCount() == 0)
    {
      if ((parambgeg instanceof bgep))
      {
        this.jdField_a_of_type_Bgec.a(parambgeg);
        this.jdField_a_of_type_Bgec.notifyDataSetChanged();
        this.jdField_a_of_type_Bgep = ((bgep)parambgeg);
        this.jdField_a_of_type_Bgep.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new bgep("");
      localObject2 = new bgep("");
      this.jdField_a_of_type_Bgec.a((bgeg)localObject1);
      this.jdField_a_of_type_Bgec.a(parambgeg);
      this.jdField_a_of_type_Bgec.a((bgeg)localObject2);
      this.jdField_a_of_type_Bgep = ((bgep)localObject2);
      this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bgep.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Bgec.notifyDataSetChanged();
      this.jdField_a_of_type_Bgfd.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Bgep.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Bgep == null)
    {
      localObject1 = this.jdField_a_of_type_Bgec.a(this.jdField_a_of_type_Bgec.getItemCount() - 1);
      if ((localObject1 instanceof bgep))
      {
        this.jdField_a_of_type_Bgep = ((bgep)localObject1);
        this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Bgep.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Bgep.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Bgep.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Bgep.jdField_a_of_type_Int;
      localObject1 = (bgfu)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bgfu)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Bgep.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambgeg instanceof bgep)) {
          break label519;
        }
        parambgeg = (bgep)parambgeg;
        this.jdField_a_of_type_Bgep.b((String)localObject2 + parambgeg.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Bgep;
        ((bgep)localObject1).jdField_a_of_type_Int += parambgeg.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Bgep.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bgfd.a(null, false);
        return;
        localObject1 = new bgep("");
        this.jdField_a_of_type_Bgep = ((bgep)localObject1);
        this.jdField_a_of_type_Bgep.jdField_c_of_type_Int = this.jdField_a_of_type_Bgec.getItemCount();
        this.jdField_a_of_type_Bgec.a((bgeg)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Bgep.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Bgep.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Bgep.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Bgep.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      bgeg localbgeg = this.jdField_a_of_type_Bgec.a(j);
      if ((localbgeg instanceof bgep)) {
        ((bgep)localbgeg).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new bgep((String)localObject1);
        this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = false;
        ((bgep)localObject1).jdField_a_of_type_Boolean = true;
        ((bgep)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Bgep = ((bgep)localObject1);
        this.jdField_a_of_type_Bgec.a(j + 1, (bgeg)localObject1);
        this.jdField_a_of_type_Bgec.a(j + 1, parambgeg);
        this.jdField_a_of_type_Bgep.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Bgec.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<bgeq> paramArrayList)
  {
    this.jdField_a_of_type_Bgec.a(paramArrayList);
  }
  
  public void a(List<bgeg> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((bgeg)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bgec.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<bgek> b()
  {
    return this.jdField_a_of_type_Bgec.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = false;
    bgfu localbgfu = (bgfu)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bgep.jdField_c_of_type_Int);
    if (localbgfu != null)
    {
      localbgfu.a.setFocusable(false);
      localbgfu.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbgfu));
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
    return this.jdField_a_of_type_Bgec.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Bgfg.a(null);
    if (this.jdField_a_of_type_Bgec.b())
    {
      this.jdField_a_of_type_Bgec.b(0);
      this.jdField_a_of_type_Bgec.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Bgec.a();
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
          blgx.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(bgdy parambgdy)
  {
    this.jdField_a_of_type_Bgdy = parambgdy;
  }
  
  public void setContentLengthChangeListener(bgdz parambgdz)
  {
    this.jdField_a_of_type_Bgdz = parambgdz;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bgec.a(new JSONArray(paramString));
      this.jdField_a_of_type_Bgfd.a(null, false);
      int i = this.jdField_a_of_type_Bgec.b();
      this.jdField_a_of_type_Bgfd.a(this.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Int = i;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDataByEdit(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          bgeg localbgeg = bgeh.a(paramJSONArray.getJSONObject(i));
          if (localbgeg == null) {
            break label201;
          }
          if ((localbgeg instanceof bgeq))
          {
            ((bgeq)localbgeg).g = 3;
            if ((localbgeg instanceof bgel)) {
              ((bgel)localbgeg).e = 100;
            }
          }
          if ((localbgeg instanceof bgep))
          {
            this.jdField_a_of_type_Bgep.b(((bgep)localbgeg).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bgep.jdField_a_of_type_Int = ((bgep)localbgeg).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Bgec.notifyDataSetChanged();
          }
          else
          {
            a(localbgeg);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Bgec.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Bgec.a(i);
          if ((paramJSONArray instanceof bgep))
          {
            this.jdField_a_of_type_Bgep = ((bgep)paramJSONArray);
            this.jdField_a_of_type_Bgep.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Bgec.notifyDataSetChanged();
          scrollToPosition(0);
          return;
        }
        i += 1;
      }
      label201:
      i += 1;
    }
  }
  
  public void setDefaultContent()
  {
    setData("[" + new bgep("").toString() + "]");
    this.jdField_a_of_type_Bgep = ((bgep)this.jdField_a_of_type_Bgec.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(bgea parambgea)
  {
    this.jdField_a_of_type_Bgea = parambgea;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bgfg.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Bgec.b())
    {
      this.jdField_a_of_type_Bgec.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Bgec.a(0, new bgej());
    this.jdField_a_of_type_Bgec.notifyDataSetChanged();
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
    this.jdField_a_of_type_Bgec.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */