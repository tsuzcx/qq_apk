package cooperation.qzone.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import bmws;
import bmwt;
import bmwu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Map;

public class FeedListView
  extends XListView
{
  protected Map<String, String> a;
  private boolean a;
  
  public FeedListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = Collections.emptyMap();
  }
  
  public FeedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilMap = Collections.emptyMap();
  }
  
  public FeedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilMap = Collections.emptyMap();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(bmwu parambmwu) {}
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong) {}
  
  public boolean a(String paramString, bmwu parambmwu)
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void f() {}
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void l() {}
  
  public void m() {}
  
  public void setExpandHead(bmws parambmws) {}
  
  public void setExtArgs(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void setFeedUinChangedListener(bmwt parambmwt) {}
  
  public void setLongClickValid(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void u_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.FeedListView
 * JD-Core Version:    0.7.0.1
 */