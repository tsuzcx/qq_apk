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
import bbzg;
import bbzh;
import bbzi;
import bbzj;
import bbzk;
import bbzl;
import bbzp;
import bbzq;
import bbzs;
import bbzt;
import bbzu;
import bbzy;
import bbzz;
import bcad;
import bcag;
import bcam;
import bcap;
import bcar;
import bcax;
import bcbd;
import bcbf;
import bhoc;
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
  private bbzh jdField_a_of_type_Bbzh;
  private bbzi jdField_a_of_type_Bbzi;
  private bbzj jdField_a_of_type_Bbzj;
  public bbzl a;
  private bbzy jdField_a_of_type_Bbzy;
  bcam jdField_a_of_type_Bcam = new bbzg(this);
  private bcap jdField_a_of_type_Bcap;
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
    addItemDecoration(new bbzk(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Bcap = new bcap(this, paramContext);
    this.jdField_a_of_type_Bcap.a(this.jdField_a_of_type_Bcam);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Bcap);
    paramAttributeSet.put(0, new bcax(this, paramContext).a(this.jdField_a_of_type_Bcam));
    paramAttributeSet.put(3, new bcag(this, paramContext).a(this.jdField_a_of_type_Bcam));
    paramAttributeSet.put(1, new bcar(this).a(this.jdField_a_of_type_Bcam));
    paramAttributeSet.put(2, new bcbf(this).a(this.jdField_a_of_type_Bcam));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Bcam));
    paramAttributeSet.put(7, new bcad(this, paramContext).a(this.jdField_a_of_type_Bcam));
    this.jdField_a_of_type_Bbzl = new bbzl(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Bbzl);
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
    for (int j = 0; i < this.jdField_a_of_type_Bbzl.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Bbzl.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bbzl.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<bbzz> a()
  {
    return this.jdField_a_of_type_Bbzl.a();
  }
  
  public ArrayList<bbzp> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bbzl.getItemCount())
    {
      if (this.jdField_a_of_type_Bbzl.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Bbzl.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
    bcbd localbcbd = (bcbd)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int);
    if (localbcbd != null)
    {
      localbcbd.a.setFocusable(true);
      localbcbd.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbcbd));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Bbzl.b(0);
      this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
      this.jdField_a_of_type_Bcam.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Bbzl.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Bbzl.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Bbzl.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof bbzy))
        {
          if (this.jdField_a_of_type_Bbzy != null) {
            this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Bbzy = ((bbzy)localObject2);
          this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Bbzl.b(paramInt);
        this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
        this.jdField_a_of_type_Bcam.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof bbzy)) || (!(localObject2 instanceof bbzy)))
      {
        this.jdField_a_of_type_Bbzl.b(paramInt);
        this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
        this.jdField_a_of_type_Bcam.a(null, false);
        return;
      }
      localObject1 = (bbzy)localObject1;
      localObject2 = (bbzy)localObject2;
      ((bbzy)localObject2).jdField_a_of_type_Int = ((bbzy)localObject2).jdField_a_of_type_JavaLangString.length();
      bcbd localbcbd = (bcbd)findViewHolderForAdapterPosition(((bbzy)localObject2).jdField_c_of_type_Int);
      if (localbcbd != null) {
        localbcbd.a.setSelection(((bbzy)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((bbzy)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Bbzy != null) {
          this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Bbzy = ((bbzy)localObject2);
        this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bbzl.b(paramInt + 1);
        this.jdField_a_of_type_Bbzl.b(paramInt);
        this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
        this.jdField_a_of_type_Bcam.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((bbzy)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((bbzy)localObject2).jdField_a_of_type_JavaLangString = ((bbzy)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((bbzy)localObject2).jdField_a_of_type_JavaLangString += ((bbzy)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Bbzl.a(paramInt, paramString);
    this.jdField_a_of_type_Bcam.a(null, false);
  }
  
  public void a(bbzp parambbzp)
  {
    if (parambbzp == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Bbzl.getItemCount() == 0)
    {
      if ((parambbzp instanceof bbzy))
      {
        this.jdField_a_of_type_Bbzl.a(parambbzp);
        this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
        this.jdField_a_of_type_Bbzy = ((bbzy)parambbzp);
        this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new bbzy("");
      localObject2 = new bbzy("");
      this.jdField_a_of_type_Bbzl.a((bbzp)localObject1);
      this.jdField_a_of_type_Bbzl.a(parambbzp);
      this.jdField_a_of_type_Bbzl.a((bbzp)localObject2);
      this.jdField_a_of_type_Bbzy = ((bbzy)localObject2);
      this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
      this.jdField_a_of_type_Bcam.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Bbzy == null)
    {
      localObject1 = this.jdField_a_of_type_Bbzl.a(this.jdField_a_of_type_Bbzl.getItemCount() - 1);
      if ((localObject1 instanceof bbzy))
      {
        this.jdField_a_of_type_Bbzy = ((bbzy)localObject1);
        this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Bbzy.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Bbzy.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Bbzy.jdField_a_of_type_Int;
      localObject1 = (bcbd)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bcbd)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Bbzy.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambbzp instanceof bbzy)) {
          break label519;
        }
        parambbzp = (bbzy)parambbzp;
        this.jdField_a_of_type_Bbzy.b((String)localObject2 + parambbzp.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Bbzy;
        ((bbzy)localObject1).jdField_a_of_type_Int += parambbzp.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bcam.a(null, false);
        return;
        localObject1 = new bbzy("");
        this.jdField_a_of_type_Bbzy = ((bbzy)localObject1);
        this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int = this.jdField_a_of_type_Bbzl.getItemCount();
        this.jdField_a_of_type_Bbzl.a((bbzp)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Bbzy.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Bbzy.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Bbzy.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Bbzy.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      bbzp localbbzp = this.jdField_a_of_type_Bbzl.a(j);
      if ((localbbzp instanceof bbzy)) {
        ((bbzy)localbbzp).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new bbzy((String)localObject1);
        this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = false;
        ((bbzy)localObject1).jdField_a_of_type_Boolean = true;
        ((bbzy)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Bbzy = ((bbzy)localObject1);
        this.jdField_a_of_type_Bbzl.a(j + 1, (bbzp)localObject1);
        this.jdField_a_of_type_Bbzl.a(j + 1, parambbzp);
        this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<bbzz> paramArrayList)
  {
    this.jdField_a_of_type_Bbzl.a(paramArrayList);
  }
  
  public void a(List<bbzp> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((bbzp)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bbzl.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<bbzt> b()
  {
    return this.jdField_a_of_type_Bbzl.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = false;
    bcbd localbcbd = (bcbd)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bbzy.jdField_c_of_type_Int);
    if (localbcbd != null)
    {
      localbcbd.a.setFocusable(false);
      localbcbd.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbcbd));
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
    return this.jdField_a_of_type_Bbzl.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Bcap.a(null);
    if (this.jdField_a_of_type_Bbzl.b())
    {
      this.jdField_a_of_type_Bbzl.b(0);
      this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Bbzl.a();
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
          bhoc.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(bbzh parambbzh)
  {
    this.jdField_a_of_type_Bbzh = parambbzh;
  }
  
  public void setContentLengthChangeListener(bbzi parambbzi)
  {
    this.jdField_a_of_type_Bbzi = parambbzi;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bbzl.a(new JSONArray(paramString));
      this.jdField_a_of_type_Bcam.a(null, false);
      int i = this.jdField_a_of_type_Bbzl.b();
      this.jdField_a_of_type_Bcam.a(this.jdField_a_of_type_Int, i);
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
          bbzp localbbzp = bbzq.a(paramJSONArray.getJSONObject(i));
          if (localbbzp == null) {
            break label201;
          }
          if ((localbbzp instanceof bbzz))
          {
            ((bbzz)localbbzp).g = 3;
            if ((localbbzp instanceof bbzu)) {
              ((bbzu)localbbzp).e = 100;
            }
          }
          if ((localbbzp instanceof bbzy))
          {
            this.jdField_a_of_type_Bbzy.b(((bbzy)localbbzp).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bbzy.jdField_a_of_type_Int = ((bbzy)localbbzp).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
          }
          else
          {
            a(localbbzp);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Bbzl.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Bbzl.a(i);
          if ((paramJSONArray instanceof bbzy))
          {
            this.jdField_a_of_type_Bbzy = ((bbzy)paramJSONArray);
            this.jdField_a_of_type_Bbzy.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
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
    setData("[" + new bbzy("").toString() + "]");
    this.jdField_a_of_type_Bbzy = ((bbzy)this.jdField_a_of_type_Bbzl.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(bbzj parambbzj)
  {
    this.jdField_a_of_type_Bbzj = parambbzj;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bcap.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Bbzl.b())
    {
      this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Bbzl.a(0, new bbzs());
    this.jdField_a_of_type_Bbzl.notifyDataSetChanged();
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
    this.jdField_a_of_type_Bbzl.a(paramInt);
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