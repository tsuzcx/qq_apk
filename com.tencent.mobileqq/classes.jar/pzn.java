import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pzn
  implements pze<BEAN>
{
  pzn(pzl parampzl) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (pzl.a(this.a) != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      pzl.a(this.a).setListData(paramList, true);
      if (pzl.a(this.a).a()) {
        pzl.a(this.a).setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    pzl.a(this.a).setFooterNoMore();
    return;
    label69:
    QLog.i("ListPresenter", 2, "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
    pzl.a(this.a).setFooterError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzn
 * JD-Core Version:    0.7.0.1
 */