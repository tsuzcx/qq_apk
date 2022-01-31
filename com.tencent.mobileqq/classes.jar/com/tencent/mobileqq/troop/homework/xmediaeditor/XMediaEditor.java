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
import baax;
import baay;
import baaz;
import baba;
import babb;
import babc;
import babg;
import babh;
import babj;
import babk;
import babl;
import babp;
import babq;
import babu;
import babx;
import bacd;
import bacg;
import baci;
import baco;
import bacu;
import bacw;
import bfni;
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
  private baay jdField_a_of_type_Baay;
  private baaz jdField_a_of_type_Baaz;
  private baba jdField_a_of_type_Baba;
  public babc a;
  private babp jdField_a_of_type_Babp;
  bacd jdField_a_of_type_Bacd = new baax(this);
  private bacg jdField_a_of_type_Bacg;
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
    addItemDecoration(new babb(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_Bacg = new bacg(this, paramContext);
    this.jdField_a_of_type_Bacg.a(this.jdField_a_of_type_Bacd);
    paramAttributeSet.put(-1, this.jdField_a_of_type_Bacg);
    paramAttributeSet.put(0, new baco(this, paramContext).a(this.jdField_a_of_type_Bacd));
    paramAttributeSet.put(3, new babx(this, paramContext).a(this.jdField_a_of_type_Bacd));
    paramAttributeSet.put(1, new baci(this).a(this.jdField_a_of_type_Bacd));
    paramAttributeSet.put(2, new bacw(this).a(this.jdField_a_of_type_Bacd));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_Bacd));
    paramAttributeSet.put(7, new babu(this, paramContext).a(this.jdField_a_of_type_Bacd));
    this.jdField_a_of_type_Babc = new babc(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_Babc);
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
    for (int j = 0; i < this.jdField_a_of_type_Babc.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_Babc.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Babc.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<babq> a()
  {
    return this.jdField_a_of_type_Babc.a();
  }
  
  public ArrayList<babg> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Babc.getItemCount())
    {
      if (this.jdField_a_of_type_Babc.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_Babc.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
    bacu localbacu = (bacu)findViewHolderForAdapterPosition(this.jdField_a_of_type_Babp.jdField_c_of_type_Int);
    if (localbacu != null)
    {
      localbacu.a.setFocusable(true);
      localbacu.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, localbacu));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Babc.b(0);
      this.jdField_a_of_type_Babc.notifyDataSetChanged();
      this.jdField_a_of_type_Bacd.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Babc.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_Babc.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_Babc.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof babp))
        {
          if (this.jdField_a_of_type_Babp != null) {
            this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_Babp = ((babp)localObject2);
          this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Babc.b(paramInt);
        this.jdField_a_of_type_Babc.notifyDataSetChanged();
        this.jdField_a_of_type_Bacd.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof babp)) || (!(localObject2 instanceof babp)))
      {
        this.jdField_a_of_type_Babc.b(paramInt);
        this.jdField_a_of_type_Babc.notifyDataSetChanged();
        this.jdField_a_of_type_Bacd.a(null, false);
        return;
      }
      localObject1 = (babp)localObject1;
      localObject2 = (babp)localObject2;
      ((babp)localObject2).jdField_a_of_type_Int = ((babp)localObject2).jdField_a_of_type_JavaLangString.length();
      bacu localbacu = (bacu)findViewHolderForAdapterPosition(((babp)localObject2).jdField_c_of_type_Int);
      if (localbacu != null) {
        localbacu.a.setSelection(((babp)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((babp)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Babp != null) {
          this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Babp = ((babp)localObject2);
        this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Babc.b(paramInt + 1);
        this.jdField_a_of_type_Babc.b(paramInt);
        this.jdField_a_of_type_Babc.notifyDataSetChanged();
        this.jdField_a_of_type_Bacd.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((babp)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((babp)localObject2).jdField_a_of_type_JavaLangString = ((babp)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((babp)localObject2).jdField_a_of_type_JavaLangString += ((babp)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Babc.a(paramInt, paramString);
    this.jdField_a_of_type_Bacd.a(null, false);
  }
  
  public void a(babg parambabg)
  {
    if (parambabg == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Babc.getItemCount() == 0)
    {
      if ((parambabg instanceof babp))
      {
        this.jdField_a_of_type_Babc.a(parambabg);
        this.jdField_a_of_type_Babc.notifyDataSetChanged();
        this.jdField_a_of_type_Babp = ((babp)parambabg);
        this.jdField_a_of_type_Babp.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new babp("");
      localObject2 = new babp("");
      this.jdField_a_of_type_Babc.a((babg)localObject1);
      this.jdField_a_of_type_Babc.a(parambabg);
      this.jdField_a_of_type_Babc.a((babg)localObject2);
      this.jdField_a_of_type_Babp = ((babp)localObject2);
      this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Babp.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Babc.notifyDataSetChanged();
      this.jdField_a_of_type_Bacd.a(null, false);
      scrollToPosition(this.jdField_a_of_type_Babp.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_Babp == null)
    {
      localObject1 = this.jdField_a_of_type_Babc.a(this.jdField_a_of_type_Babc.getItemCount() - 1);
      if ((localObject1 instanceof babp))
      {
        this.jdField_a_of_type_Babp = ((babp)localObject1);
        this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_Babp.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Babp.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Babp.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_Babp.jdField_a_of_type_Int;
      localObject1 = (bacu)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label663;
      }
      i = ((bacu)localObject1).a.getSelectionStart();
    }
    label519:
    label663:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_Babp.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (!(parambabg instanceof babp)) {
          break label519;
        }
        parambabg = (babp)parambabg;
        this.jdField_a_of_type_Babp.b((String)localObject2 + parambabg.jdField_a_of_type_JavaLangString + (String)localObject1);
        localObject1 = this.jdField_a_of_type_Babp;
        ((babp)localObject1).jdField_a_of_type_Int += parambabg.jdField_a_of_type_JavaLangString.length();
        scrollToPosition(this.jdField_a_of_type_Babp.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bacd.a(null, false);
        return;
        localObject1 = new babp("");
        this.jdField_a_of_type_Babp = ((babp)localObject1);
        this.jdField_a_of_type_Babp.jdField_c_of_type_Int = this.jdField_a_of_type_Babc.getItemCount();
        this.jdField_a_of_type_Babc.a((babg)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_Babp.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        continue;
        localObject2 = this.jdField_a_of_type_Babp.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_Babp.jdField_a_of_type_JavaLangString.length() == i) {
          localObject1 = "";
        } else {
          localObject1 = this.jdField_a_of_type_Babp.jdField_a_of_type_JavaLangString.substring(i);
        }
      }
      babg localbabg = this.jdField_a_of_type_Babc.a(j);
      if ((localbabg instanceof babp)) {
        ((babp)localbabg).b((String)localObject2);
      }
      for (;;)
      {
        localObject1 = new babp((String)localObject1);
        this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = false;
        ((babp)localObject1).jdField_a_of_type_Boolean = true;
        ((babp)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Babp = ((babp)localObject1);
        this.jdField_a_of_type_Babc.a(j + 1, (babg)localObject1);
        this.jdField_a_of_type_Babc.a(j + 1, parambabg);
        this.jdField_a_of_type_Babp.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_Babc.notifyDataSetChanged();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("XMediaEditor", 2, "insert item 类型不对 insertPosition" + j);
        }
      }
    }
  }
  
  public void a(ArrayList<babq> paramArrayList)
  {
    this.jdField_a_of_type_Babc.a(paramArrayList);
  }
  
  public void a(List<babg> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((babg)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Babc.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<babk> b()
  {
    return this.jdField_a_of_type_Babc.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = false;
    bacu localbacu = (bacu)findViewHolderForAdapterPosition(this.jdField_a_of_type_Babp.jdField_c_of_type_Int);
    if (localbacu != null)
    {
      localbacu.a.setFocusable(false);
      localbacu.a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, localbacu));
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
    return this.jdField_a_of_type_Babc.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Bacg.a(null);
    if (this.jdField_a_of_type_Babc.b())
    {
      this.jdField_a_of_type_Babc.b(0);
      this.jdField_a_of_type_Babc.notifyDataSetChanged();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Babc.a();
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
          bfni.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(baay parambaay)
  {
    this.jdField_a_of_type_Baay = parambaay;
  }
  
  public void setContentLengthChangeListener(baaz parambaaz)
  {
    this.jdField_a_of_type_Baaz = parambaaz;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Babc.a(new JSONArray(paramString));
      this.jdField_a_of_type_Bacd.a(null, false);
      int i = this.jdField_a_of_type_Babc.b();
      this.jdField_a_of_type_Bacd.a(this.jdField_a_of_type_Int, i);
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
          babg localbabg = babh.a(paramJSONArray.getJSONObject(i));
          if (localbabg == null) {
            break label201;
          }
          if ((localbabg instanceof babq))
          {
            ((babq)localbabg).g = 3;
            if ((localbabg instanceof babl)) {
              ((babl)localbabg).e = 100;
            }
          }
          if ((localbabg instanceof babp))
          {
            this.jdField_a_of_type_Babp.b(((babp)localbabg).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Babp.jdField_a_of_type_Int = ((babp)localbabg).jdField_a_of_type_JavaLangString.length();
            this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Babc.notifyDataSetChanged();
          }
          else
          {
            a(localbabg);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      int j = this.jdField_a_of_type_Babc.b();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramJSONArray = this.jdField_a_of_type_Babc.a(i);
          if ((paramJSONArray instanceof babp))
          {
            this.jdField_a_of_type_Babp = ((babp)paramJSONArray);
            this.jdField_a_of_type_Babp.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Babc.notifyDataSetChanged();
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
    setData("[" + new babp("").toString() + "]");
    this.jdField_a_of_type_Babp = ((babp)this.jdField_a_of_type_Babc.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(baba parambaba)
  {
    this.jdField_a_of_type_Baba = parambaba;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bacg.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Babc.b())
    {
      this.jdField_a_of_type_Babc.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Babc.a(0, new babj());
    this.jdField_a_of_type_Babc.notifyDataSetChanged();
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
    this.jdField_a_of_type_Babc.a(paramInt);
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