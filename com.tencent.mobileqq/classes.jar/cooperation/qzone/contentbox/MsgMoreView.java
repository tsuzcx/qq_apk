package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import bdkf;
import bjef;
import bjex;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import java.util.ArrayList;

public class MsgMoreView
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = bdkf.b(24.0F);
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private bjex jdField_a_of_type_Bjex;
  private MQMsg jdField_a_of_type_CooperationQzoneContentboxModelMQMsg;
  
  public MsgMoreView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MsgMoreView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MsgMoreView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131562182, this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131362999));
    setOnClickListener(new bjef(this));
  }
  
  public void setData(MQMsg paramMQMsg, boolean paramBoolean)
  {
    int j = 0;
    this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg = paramMQMsg;
    paramMQMsg = paramMQMsg.bottomCell;
    if (paramMQMsg.userAvatar != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      int i;
      if (5 < paramMQMsg.userAvatar.size()) {
        i = 5;
      }
      while (j < i)
      {
        UserListItemView localUserListItemView = new UserListItemView(this.jdField_a_of_type_AndroidContentContext, 1);
        localUserListItemView.setUin((String)paramMQMsg.userAvatar.get(j));
        localUserListItemView.setTranslationX(jdField_a_of_type_Int * j);
        if ((j == i - 1) && (paramMQMsg.total - i > 0)) {
          localUserListItemView.a(true);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localUserListItemView, j);
        j += 1;
        continue;
        i = paramMQMsg.userAvatar.size();
      }
    }
    if (paramBoolean) {
      ((TextView)findViewById(2131370743)).setTextColor(-7500397);
    }
  }
  
  public void setMsgOnClickListener(bjex parambjex)
  {
    this.jdField_a_of_type_Bjex = parambjex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgMoreView
 * JD-Core Version:    0.7.0.1
 */