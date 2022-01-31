import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class opp
{
  public BaseArticleInfo a;
  public String a;
  public String b;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public opp(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a = paramBaseArticleInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof opp)) {
      return false;
    }
    paramObject = (opp)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opp
 * JD-Core Version:    0.7.0.1
 */