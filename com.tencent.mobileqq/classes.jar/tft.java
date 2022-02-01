import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class tft
  implements qgq
{
  public tft(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, List<qgr> paramList)
  {
    QLog.d("FastWebActivity", 1, "live Status Callback");
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        qgr localqgr = (qgr)paramList.next();
        if ((localqgr.jdField_a_of_type_Long == FastWebActivity.a(this.a).d) && (localqgr.jdField_a_of_type_Qgp.a == 1))
        {
          QLog.d("FastWebActivity", 1, "need to show live status");
          FastWebActivity.c(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tft
 * JD-Core Version:    0.7.0.1
 */