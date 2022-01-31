import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class oyv
  extends oya
{
  private void i()
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    int i = ((AbsListView)localObject).getFirstVisiblePosition();
    int k = ((AbsListView)localObject).getLastVisiblePosition();
    label24:
    BaseArticleInfo localBaseArticleInfo;
    StringBuilder localStringBuilder;
    if (i <= k)
    {
      localObject = a(i);
      if (localObject != null)
      {
        localBaseArticleInfo = (BaseArticleInfo)localObject;
        str = onk.a(localBaseArticleInfo);
        int j = 0;
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          localObject = onk.b(localBaseArticleInfo);
          j = 1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("1".equals(Uri.parse((String)localObject).getQueryParameter("v_feeds_preload"))))
        {
          qke.a().b((String)localObject);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("preloadFrom: ");
            if (j != 0) {
              break label186;
            }
          }
        }
      }
    }
    label186:
    for (String str = "Gallery";; str = "ShortContent")
    {
      QLog.d("ViolaHandler", 2, str + " and invoke webpreload data ,openUrl = " + (String)localObject + ";articleInfo = " + localBaseArticleInfo.toString());
      i += 1;
      break label24;
      break;
    }
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyv
 * JD-Core Version:    0.7.0.1
 */