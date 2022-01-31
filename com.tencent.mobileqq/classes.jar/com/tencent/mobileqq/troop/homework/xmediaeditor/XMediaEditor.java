package com.tencent.mobileqq.troop.homework.xmediaeditor;

import ajrq;
import ajrs;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HeaderInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase.OnEditItemListener;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.HeaderItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
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
  private XMediaEditor.ICommitStateChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$ICommitStateChangeListener;
  private XMediaEditor.IContentLengthChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IContentLengthChangeListener;
  private XMediaEditor.IFocusChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IFocusChangeListener;
  public XMediaEditorAdapter a;
  private TextInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
  EditItemBase.OnEditItemListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener = new ajrs(this);
  private HeaderItem jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean;
  
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
    addItemDecoration(new XMediaEditor.SpaceItemDecoration(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem = new HeaderItem(this, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener);
    paramAttributeSet.put(-1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem);
    paramAttributeSet.put(0, new TextItem(this, paramContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(3, new AudioItem(this, paramContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(1, new ImageItem(this).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(2, new VideoItem(this).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(4, new HWReciteItem(this, paramContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(7, new ArithmeticItem(this, paramContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter = new XMediaEditorAdapter(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter);
    setDefaultContent();
  }
  
  private View a(Class paramClass, View paramView)
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
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i).b() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public ArrayList a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i).b() == paramInt) {
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
    TextItem.TextViewHolder localTextViewHolder = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int);
    if (localTextViewHolder != null)
    {
      localTextViewHolder.a.setFocusable(true);
      localTextViewHolder.a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new ajrq(this, localTextViewHolder));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramInt - 1);
    if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount()) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramInt + 1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if ((localObject2 instanceof TextInfo))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
        return;
      }
      if ((!(localObject1 instanceof TextInfo)) || (!(localObject2 instanceof TextInfo)))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
        return;
      }
      localObject1 = (TextInfo)localObject1;
      localObject2 = (TextInfo)localObject2;
      ((TextInfo)localObject2).jdField_a_of_type_Int = ((TextInfo)localObject2).jdField_a_of_type_JavaLangString.length();
      TextItem.TextViewHolder localTextViewHolder = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject2).jdField_c_of_type_Int);
      if (localTextViewHolder != null) {
        localTextViewHolder.a.setSelection(((TextInfo)localObject2).jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(((TextInfo)localObject1).jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt + 1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
        if (paramInt - 1 < 0) {
          break label369;
        }
        paramInt -= 1;
      }
      for (;;)
      {
        scrollToPosition(paramInt);
        return;
        if (TextUtils.isEmpty(((TextInfo)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((TextInfo)localObject2).jdField_a_of_type_JavaLangString = ((TextInfo)localObject1).jdField_a_of_type_JavaLangString;
          break;
        }
        ((TextInfo)localObject2).jdField_a_of_type_JavaLangString += ((TextInfo)localObject1).jdField_a_of_type_JavaLangString;
        break;
        label369:
        paramInt = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    if (paramEditItemInfoBase == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount() == 0)
    {
      if ((paramEditItemInfoBase instanceof TextInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramEditItemInfoBase);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)paramEditItemInfoBase);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new TextInfo("");
      localObject2 = new TextInfo("");
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a((EditItemInfoBase)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramEditItemInfoBase);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a((EditItemInfoBase)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int);
      return;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount() - 1);
      if ((localObject1 instanceof TextInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int = 0;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int;
      localObject1 = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(j);
      if (localObject1 == null) {
        break label615;
      }
      i = ((TextItem.TextViewHolder)localObject1).a.getSelectionStart();
    }
    label313:
    label615:
    for (;;)
    {
      if (i == 0) {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.length() == 0)
        {
          localObject2 = "";
          localObject1 = "";
          if (!(paramEditItemInfoBase instanceof TextInfo)) {
            break label519;
          }
          paramEditItemInfoBase = (TextInfo)paramEditItemInfoBase;
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.b((String)localObject2 + paramEditItemInfoBase.jdField_a_of_type_JavaLangString + (String)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
          ((TextInfo)localObject1).jdField_a_of_type_Int += paramEditItemInfoBase.jdField_a_of_type_JavaLangString.length();
        }
      }
      for (;;)
      {
        scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
        return;
        localObject1 = new TextInfo("");
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a((EditItemInfoBase)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString;
        localObject2 = "";
        break label313;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.substring(0, i);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.length() == i)
        {
          localObject1 = "";
          break label313;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.substring(i);
        break label313;
        ((TextInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(j)).b((String)localObject2);
        localObject1 = new TextInfo((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = false;
        ((TextInfo)localObject1).jdField_a_of_type_Boolean = true;
        ((TextInfo)localObject1).jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(j + 1, (EditItemInfoBase)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(j + 1, paramEditItemInfoBase);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int = (j + 2);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramArrayList);
  }
  
  public void a(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((EditItemInfoBase)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
  }
  
  public void b()
  {
    setDefaultContent();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return (this.jdField_a_of_type_Boolean) && (super.canScrollVertically(paramInt));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int != 2147483647) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (c() == 0) {
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
          InputMethodUtil.a(localEditText);
        }
      }
    }
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(XMediaEditor.ICommitStateChangeListener paramICommitStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$ICommitStateChangeListener = paramICommitStateChangeListener;
  }
  
  public void setContentLengthChangeListener(XMediaEditor.IContentLengthChangeListener paramIContentLengthChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IContentLengthChangeListener = paramIContentLengthChangeListener;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(new JSONArray(paramString));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(this.jdField_a_of_type_Int, i);
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
    setData("[" + new TextInfo("").toString() + "]");
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(XMediaEditor.IFocusChangeListener paramIFocusChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IFocusChangeListener = paramIFocusChangeListener;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(0, new HeaderInfo());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
  }
  
  public void setHint(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */