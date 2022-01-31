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
import bcdp;
import bcdq;
import bcdr;
import bcds;
import bcdt;
import bcdu;
import bcdy;
import bcdz;
import bceb;
import bcec;
import bced;
import bceh;
import bcei;
import bcem;
import bcep;
import bcev;
import bcey;
import bcfa;
import bcfg;
import bcfm;
import bcfo;
import bhsj;
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
  private bcdq jdField_a_of_type_Bcdq;
  private bcdr jdField_a_of_type_Bcdr;
  private bcds jdField_a_of_type_Bcds;
  public bcdu a;
  private bceh jdField_a_of_type_Bceh;
  bcev jdField_a_of_type_Bcev = new bcdp(this);
  private bcey jdField_a_of_type_Bcey;
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
    addItemDecoration(new bcdt(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Bcey = new bcey(this, paramContext);
    this.jdField_a_of_type_Bcey.a(this.jdField_a_of_type_Bcev);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Bcey);
    paramAttributeSet.put(0, new bcfg(this, paramContext).a(this.jdField_a_of_type_Bcev));
    paramAttributeSet.put(3, new bcep(this, paramContext).a(this.jdField_a_of_type_Bcev));
    paramAttributeSet.put(1, new bcfa(this).a(this.jdField_a_of_type_Bcev));
    paramAttributeSet.put(2, new bcfo(this).a(this.jdField_a_of_type_Bcev));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Bcev));
    paramAttributeSet.put(7, new bcem(this, paramContext).a(this.jdField_a_of_type_Bcev));
    this.jdField_a_of_type_Bcdu = new bcdu(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Bcdu);
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
    for (int j = 0; i < this.jdField_a_of_type_Bcdu.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Bcdu.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bcdu.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<bcei> a()
  {
    return this.jdField_a_of_type_Bcdu.a();
  }
  
  public ArrayList<bcdy> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bcdu.getItemCount())
    {
      if (this.jdField_a_of_type_Bcdu.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Bcdu.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
    bcfm localbcfm = (bcfm)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bceh.jdField_c_of_type_Int);
    if (localbcfm != null)
    {
      localbcfm.a.setFocusable(true);
      localbcfm.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbcfm));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Bcdu.b(0);
      this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
      this.jdField_a_of_type_Bcev.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Bcdu.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Bcdu.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Bcdu.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof bceh))
        {
          if (this.jdField_a_of_type_Bceh != null) {
            this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Bceh = ((bceh)localObject2);
          this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Bcdu.b(paramInt);
        this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
        this.jdField_a_of_type_Bcev.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof bceh)) || (!(localObject2 instanceof bceh)))
      {
        this.jdField_a_of_type_Bcdu.b(paramInt);
        this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
        this.jdField_a_of_type_Bcev.a(null, false);
        return;
      }
      localObject1 = (bceh)localObject1;
      localObject2 = (bceh)localObject2;
      ((bceh)localObject2).jdField_a_of_type_Int = ((bceh)localObject2).jdField_a_of_type_JavaLangString.length();
      bcfm localbcfm = (bcfm)findViewHolderForAdapterPosition(((bceh)localObject2).jdField_c_of_type_Int);
      if (localbcfm != null) {
        localbcfm.a.setSelection(((bceh)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((bceh)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Bceh != null) {
          this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Bceh = ((bceh)localObject2);
        this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bcdu.b(paramInt + 1);
        this.jdField_a_of_type_Bcdu.b(paramInt);
        this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
        this.jdField_a_of_type_Bcev.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((bceh)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((bceh)localObject2).jdField_a_of_type_JavaLangString = ((bceh)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((bceh)localObject2).jdField_a_of_type_JavaLangString += ((bceh)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Bcdu.a(paramInt, paramString);
    this.jdField_a_of_type_Bcev.a(null, false);
  }
  
  public void a(bcdy parambcdy)
  {
    if (parambcdy == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Bcdu.getItemCount() == 0)
    {
      if ((parambcdy instanceof bceh))
      {
        this.jdField_a_of_type_Bcdu.a(parambcdy);
        this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
        this.jdField_a_of_type_Bceh = ((bceh)parambcdy);
        this.jdField_a_of_type_Bceh.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new bceh("");
      localObject2 = new bceh("");
      this.jdField_a_of_type_Bcdu.a((bcdy)localObject1);
      this.jdField_a_of_type_Bcdu.a(parambcdy);
      this.jdField_a_of_type_Bcdu.a((bcdy)localObject2);
      this.jdField_a_of_type_Bceh = ((bceh)localObject2);
      this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bceh.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
      this.jdField_a_of_type_Bcev.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Bceh.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Bceh == null)
    {
      localObject1 = this.jdField_a_of_type_Bcdu.a(this.jdField_a_of_type_Bcdu.getItemCount() - 1);
      if ((localObject1 instanceof bceh))
      {
        this.jdField_a_of_type_Bceh = ((bceh)localObject1);
        this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Bceh.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Bceh.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Bceh.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Bceh.jdField_a_of_type_Int;
      localObject1 = (bcfm)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bcfm)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Bceh.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambcdy instanceof bceh)) {
          break label519;
        }
        parambcdy = (bceh)parambcdy;
        this.jdField_a_of_type_Bceh.b((String)localObject2 + parambcdy.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Bceh;
        ((bceh)localObject1).jdField_a_of_type_Int += parambcdy.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Bceh.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bcev.a(null, false);
        return;
        localObject1 = new bceh("");
        this.jdField_a_of_type_Bceh = ((bceh)localObject1);
        this.jdField_a_of_type_Bceh.jdField_c_of_type_Int = this.jdField_a_of_type_Bcdu.getItemCount();
        this.jdField_a_of_type_Bcdu.a((bcdy)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Bceh.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Bceh.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Bceh.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Bceh.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      bcdy localbcdy = this.jdField_a_of_type_Bcdu.a(j);
      if ((localbcdy instanceof bceh)) {
        ((bceh)localbcdy).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new bceh((String)localObject1);
        this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = false;
        ((bceh)localObject1).jdField_a_of_type_Boolean = true;
        ((bceh)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Bceh = ((bceh)localObject1);
        this.jdField_a_of_type_Bcdu.a(j + 1, (bcdy)localObject1);
        this.jdField_a_of_type_Bcdu.a(j + 1, parambcdy);
        this.jdField_a_of_type_Bceh.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<bcei> paramArrayList)
  {
    this.jdField_a_of_type_Bcdu.a(paramArrayList);
  }
  
  public void a(List<bcdy> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((bcdy)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bcdu.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<bcec> b()
  {
    return this.jdField_a_of_type_Bcdu.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = false;
    bcfm localbcfm = (bcfm)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bceh.jdField_c_of_type_Int);
    if (localbcfm != null)
    {
      localbcfm.a.setFocusable(false);
      localbcfm.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbcfm));
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
    return this.jdField_a_of_type_Bcdu.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Bcey.a(null);
    if (this.jdField_a_of_type_Bcdu.b())
    {
      this.jdField_a_of_type_Bcdu.b(0);
      this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Bcdu.a();
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
          bhsj.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(bcdq parambcdq)
  {
    this.jdField_a_of_type_Bcdq = parambcdq;
  }
  
  public void setContentLengthChangeListener(bcdr parambcdr)
  {
    this.jdField_a_of_type_Bcdr = parambcdr;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bcdu.a(new JSONArray(paramString));
      this.jdField_a_of_type_Bcev.a(null, false);
      int i = this.jdField_a_of_type_Bcdu.b();
      this.jdField_a_of_type_Bcev.a(this.jdField_a_of_type_Int, i);
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
          bcdy localbcdy = bcdz.a(paramJSONArray.getJSONObject(i));
          if (localbcdy == null) {
            break label201;
          }
          if ((localbcdy instanceof bcei))
          {
            ((bcei)localbcdy).g = 3;
            if ((localbcdy instanceof bced)) {
              ((bced)localbcdy).e = 100;
            }
          }
          if ((localbcdy instanceof bceh))
          {
            this.jdField_a_of_type_Bceh.b(((bceh)localbcdy).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bceh.jdField_a_of_type_Int = ((bceh)localbcdy).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
          }
          else
          {
            a(localbcdy);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Bcdu.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Bcdu.a(i);
          if ((paramJSONArray instanceof bceh))
          {
            this.jdField_a_of_type_Bceh = ((bceh)paramJSONArray);
            this.jdField_a_of_type_Bceh.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
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
    setData("[" + new bceh("").toString() + "]");
    this.jdField_a_of_type_Bceh = ((bceh)this.jdField_a_of_type_Bcdu.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(bcds parambcds)
  {
    this.jdField_a_of_type_Bcds = parambcds;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bcey.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Bcdu.b())
    {
      this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Bcdu.a(0, new bceb());
    this.jdField_a_of_type_Bcdu.notifyDataSetChanged();
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
    this.jdField_a_of_type_Bcdu.a(paramInt);
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