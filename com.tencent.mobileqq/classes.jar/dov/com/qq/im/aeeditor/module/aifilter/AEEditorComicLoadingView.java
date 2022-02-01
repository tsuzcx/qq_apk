package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import bmbx;
import java.io.File;

public class AEEditorComicLoadingView
  extends AEEditorAILoadingView
{
  public AEEditorComicLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AEEditorComicLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEEditorComicLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString + b + File.separator;
  }
  
  public String b()
  {
    return jdField_a_of_type_JavaLangString + c + File.separator;
  }
  
  public void setShowResult(boolean paramBoolean)
  {
    bmbx.a("AEEditorComicLoadingView", "setShowResult: " + paramBoolean);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new AEEditorComicLoadingView.1(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new AEEditorComicLoadingView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView
 * JD-Core Version:    0.7.0.1
 */