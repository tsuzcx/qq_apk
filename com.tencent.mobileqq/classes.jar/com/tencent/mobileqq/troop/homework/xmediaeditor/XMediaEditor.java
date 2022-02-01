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
import bfed;
import bfee;
import bfef;
import bfeg;
import bfeh;
import bfei;
import bfem;
import bfen;
import bfep;
import bfeq;
import bfer;
import bfev;
import bfew;
import bffa;
import bffd;
import bffj;
import bffm;
import bffo;
import bffu;
import bfga;
import bfgc;
import bkft;
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
  private bfee jdField_a_of_type_Bfee;
  private bfef jdField_a_of_type_Bfef;
  private bfeg jdField_a_of_type_Bfeg;
  public bfei a;
  private bfev jdField_a_of_type_Bfev;
  bffj jdField_a_of_type_Bffj = new bfed(this);
  private bffm jdField_a_of_type_Bffm;
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
    addItemDecoration(new bfeh(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Bffm = new bffm(this, paramContext);
    this.jdField_a_of_type_Bffm.a(this.jdField_a_of_type_Bffj);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Bffm);
    paramAttributeSet.put(0, new bffu(this, paramContext).a(this.jdField_a_of_type_Bffj));
    paramAttributeSet.put(3, new bffd(this, paramContext).a(this.jdField_a_of_type_Bffj));
    paramAttributeSet.put(1, new bffo(this).a(this.jdField_a_of_type_Bffj));
    paramAttributeSet.put(2, new bfgc(this).a(this.jdField_a_of_type_Bffj));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Bffj));
    paramAttributeSet.put(7, new bffa(this, paramContext).a(this.jdField_a_of_type_Bffj));
    this.jdField_a_of_type_Bfei = new bfei(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Bfei);
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
    for (int j = 0; i < this.jdField_a_of_type_Bfei.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Bfei.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bfei.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<bfew> a()
  {
    return this.jdField_a_of_type_Bfei.a();
  }
  
  public ArrayList<bfem> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bfei.getItemCount())
    {
      if (this.jdField_a_of_type_Bfei.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Bfei.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
    bfga localbfga = (bfga)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bfev.jdField_c_of_type_Int);
    if (localbfga != null)
    {
      localbfga.a.setFocusable(true);
      localbfga.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbfga));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Bfei.b(0);
      this.jdField_a_of_type_Bfei.notifyDataSetChanged();
      this.jdField_a_of_type_Bffj.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Bfei.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Bfei.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Bfei.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof bfev))
        {
          if (this.jdField_a_of_type_Bfev != null) {
            this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Bfev = ((bfev)localObject2);
          this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Bfei.b(paramInt);
        this.jdField_a_of_type_Bfei.notifyDataSetChanged();
        this.jdField_a_of_type_Bffj.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof bfev)) || (!(localObject2 instanceof bfev)))
      {
        this.jdField_a_of_type_Bfei.b(paramInt);
        this.jdField_a_of_type_Bfei.notifyDataSetChanged();
        this.jdField_a_of_type_Bffj.a(null, false);
        return;
      }
      localObject1 = (bfev)localObject1;
      localObject2 = (bfev)localObject2;
      ((bfev)localObject2).jdField_a_of_type_Int = ((bfev)localObject2).jdField_a_of_type_JavaLangString.length();
      bfga localbfga = (bfga)findViewHolderForAdapterPosition(((bfev)localObject2).jdField_c_of_type_Int);
      if (localbfga != null) {
        localbfga.a.setSelection(((bfev)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((bfev)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Bfev != null) {
          this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Bfev = ((bfev)localObject2);
        this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bfei.b(paramInt + 1);
        this.jdField_a_of_type_Bfei.b(paramInt);
        this.jdField_a_of_type_Bfei.notifyDataSetChanged();
        this.jdField_a_of_type_Bffj.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((bfev)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((bfev)localObject2).jdField_a_of_type_JavaLangString = ((bfev)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((bfev)localObject2).jdField_a_of_type_JavaLangString += ((bfev)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Bfei.a(paramInt, paramString);
    this.jdField_a_of_type_Bffj.a(null, false);
  }
  
  public void a(bfem parambfem)
  {
    if (parambfem == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Bfei.getItemCount() == 0)
    {
      if ((parambfem instanceof bfev))
      {
        this.jdField_a_of_type_Bfei.a(parambfem);
        this.jdField_a_of_type_Bfei.notifyDataSetChanged();
        this.jdField_a_of_type_Bfev = ((bfev)parambfem);
        this.jdField_a_of_type_Bfev.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new bfev("");
      localObject2 = new bfev("");
      this.jdField_a_of_type_Bfei.a((bfem)localObject1);
      this.jdField_a_of_type_Bfei.a(parambfem);
      this.jdField_a_of_type_Bfei.a((bfem)localObject2);
      this.jdField_a_of_type_Bfev = ((bfev)localObject2);
      this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bfev.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Bfei.notifyDataSetChanged();
      this.jdField_a_of_type_Bffj.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Bfev.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Bfev == null)
    {
      localObject1 = this.jdField_a_of_type_Bfei.a(this.jdField_a_of_type_Bfei.getItemCount() - 1);
      if ((localObject1 instanceof bfev))
      {
        this.jdField_a_of_type_Bfev = ((bfev)localObject1);
        this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Bfev.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Bfev.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Bfev.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Bfev.jdField_a_of_type_Int;
      localObject1 = (bfga)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bfga)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Bfev.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambfem instanceof bfev)) {
          break label519;
        }
        parambfem = (bfev)parambfem;
        this.jdField_a_of_type_Bfev.b((String)localObject2 + parambfem.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Bfev;
        ((bfev)localObject1).jdField_a_of_type_Int += parambfem.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Bfev.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bffj.a(null, false);
        return;
        localObject1 = new bfev("");
        this.jdField_a_of_type_Bfev = ((bfev)localObject1);
        this.jdField_a_of_type_Bfev.jdField_c_of_type_Int = this.jdField_a_of_type_Bfei.getItemCount();
        this.jdField_a_of_type_Bfei.a((bfem)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Bfev.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Bfev.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Bfev.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Bfev.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      bfem localbfem = this.jdField_a_of_type_Bfei.a(j);
      if ((localbfem instanceof bfev)) {
        ((bfev)localbfem).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new bfev((String)localObject1);
        this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = false;
        ((bfev)localObject1).jdField_a_of_type_Boolean = true;
        ((bfev)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Bfev = ((bfev)localObject1);
        this.jdField_a_of_type_Bfei.a(j + 1, (bfem)localObject1);
        this.jdField_a_of_type_Bfei.a(j + 1, parambfem);
        this.jdField_a_of_type_Bfev.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Bfei.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<bfew> paramArrayList)
  {
    this.jdField_a_of_type_Bfei.a(paramArrayList);
  }
  
  public void a(List<bfem> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((bfem)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bfei.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<bfeq> b()
  {
    return this.jdField_a_of_type_Bfei.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = false;
    bfga localbfga = (bfga)findViewHolderForAdapterPosition(this.jdField_a_of_type_Bfev.jdField_c_of_type_Int);
    if (localbfga != null)
    {
      localbfga.a.setFocusable(false);
      localbfga.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbfga));
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
    return this.jdField_a_of_type_Bfei.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Bffm.a(null);
    if (this.jdField_a_of_type_Bfei.b())
    {
      this.jdField_a_of_type_Bfei.b(0);
      this.jdField_a_of_type_Bfei.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Bfei.a();
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
          bkft.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(bfee parambfee)
  {
    this.jdField_a_of_type_Bfee = parambfee;
  }
  
  public void setContentLengthChangeListener(bfef parambfef)
  {
    this.jdField_a_of_type_Bfef = parambfef;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bfei.a(new JSONArray(paramString));
      this.jdField_a_of_type_Bffj.a(null, false);
      int i = this.jdField_a_of_type_Bfei.b();
      this.jdField_a_of_type_Bffj.a(this.jdField_a_of_type_Int, i);
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
          bfem localbfem = bfen.a(paramJSONArray.getJSONObject(i));
          if (localbfem == null) {
            break label201;
          }
          if ((localbfem instanceof bfew))
          {
            ((bfew)localbfem).g = 3;
            if ((localbfem instanceof bfer)) {
              ((bfer)localbfem).e = 100;
            }
          }
          if ((localbfem instanceof bfev))
          {
            this.jdField_a_of_type_Bfev.b(((bfev)localbfem).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bfev.jdField_a_of_type_Int = ((bfev)localbfem).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Bfei.notifyDataSetChanged();
          }
          else
          {
            a(localbfem);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Bfei.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Bfei.a(i);
          if ((paramJSONArray instanceof bfev))
          {
            this.jdField_a_of_type_Bfev = ((bfev)paramJSONArray);
            this.jdField_a_of_type_Bfev.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Bfei.notifyDataSetChanged();
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
    setData("[" + new bfev("").toString() + "]");
    this.jdField_a_of_type_Bfev = ((bfev)this.jdField_a_of_type_Bfei.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(bfeg parambfeg)
  {
    this.jdField_a_of_type_Bfeg = parambfeg;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bffm.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Bfei.b())
    {
      this.jdField_a_of_type_Bfei.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Bfei.a(0, new bfep());
    this.jdField_a_of_type_Bfei.notifyDataSetChanged();
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
    this.jdField_a_of_type_Bfei.a(paramInt);
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