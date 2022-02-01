package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AEEditorTextCategoryItemView
  extends FrameLayout
{
  TextView a;
  
  public AEEditorTextCategoryItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorTextCategoryItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorTextCategoryItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((TextView)LayoutInflater.from(paramContext).inflate(2131558565, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextCategoryItemView
 * JD-Core Version:    0.7.0.1
 */