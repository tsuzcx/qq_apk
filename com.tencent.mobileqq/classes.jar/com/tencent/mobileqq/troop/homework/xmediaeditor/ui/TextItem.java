package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import aiwz;
import aixb;
import aixc;
import aixd;
import aixe;
import aixf;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class TextItem
  extends EditItemBase
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public TextItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public TextItem.TextViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextItem.TextViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970605, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new aiwz(this));
    return paramViewGroup;
  }
  
  public String a(String paramString)
  {
    paramString = (paramString + "a").split("\n");
    if (paramString.length > 0)
    {
      paramString = paramString[(paramString.length - 1)];
      if (Pattern.compile("^[1-9]\\d*[、,，.)）]\\d+").matcher(paramString).find()) {
        return "";
      }
      paramString = Pattern.compile("^[1-9]\\d*[、,，.)）]").matcher(paramString);
      if (paramString.find())
      {
        String str = paramString.group();
        paramString = str.substring(0, str.length() - 1);
        str = str.substring(str.length() - 1);
        int i = Integer.parseInt(paramString);
        return i + 1 + str;
      }
    }
    return "";
  }
  
  public void a(View paramView, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public void a(TextItem.TextViewHolder paramTextViewHolder)
  {
    super.b(paramTextViewHolder);
  }
  
  public void a(TextItem.TextViewHolder paramTextViewHolder, TextInfo paramTextInfo, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + paramTextViewHolder.hashCode() + ", mData.position:" + paramTextInfo.c + ", text:" + paramTextInfo.jdField_a_of_type_JavaLangString);
    if (paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + paramTextInfo.c + ", text:" + paramTextInfo.jdField_a_of_type_JavaLangString + ",Listener:" + paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher.toString());
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher);
      paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTextInfo.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(paramTextInfo.jdField_a_of_type_JavaLangString))
      {
        paramTextViewHolder.itemView.setVisibility(8);
        paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setText(paramTextInfo.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + paramTextInfo.c + ", text:" + paramTextInfo.jdField_a_of_type_JavaLangString);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new aixb(this, paramTextViewHolder));
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new aixc(this, paramTextViewHolder));
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aixd(this, paramTextInfo, paramTextViewHolder));
      paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher = new aixe(this, paramTextViewHolder, paramTextInfo);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + paramTextInfo.c + ", text:" + paramTextInfo.jdField_a_of_type_JavaLangString + ",Listener:" + paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher.toString());
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher);
      if (paramTextInfo.jdField_a_of_type_Boolean)
      {
        paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new aixf(this, paramTextViewHolder, paramTextInfo));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).c == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).c == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramTextViewHolder.itemView.setVisibility(0);
  }
  
  public void b(TextItem.TextViewHolder paramTextViewHolder)
  {
    super.a(paramTextViewHolder);
    TextInfo localTextInfo = (TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase;
    if (paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).c + ", text:" + localTextInfo.jdField_a_of_type_JavaLangString + ",Listener:" + paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher.toString());
      paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    localTextInfo.jdField_a_of_type_Int = paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem
 * JD-Core Version:    0.7.0.1
 */