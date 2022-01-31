import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;

public class tep
{
  public static tep a()
  {
    return new tep();
  }
  
  private tgt a(String paramString, int paramInt)
  {
    return new ter(this, paramInt, paramString);
  }
  
  private void c(String paramString, int paramInt)
  {
    FollowEvent localFollowEvent = new FollowEvent();
    localFollowEvent.setPersonId(paramString);
    if (paramInt == 1) {
      localFollowEvent.setIsFollow(1);
    }
    for (;;)
    {
      tff.a().a(localFollowEvent);
      return;
      localFollowEvent.setIsFollow(2);
    }
  }
  
  public void a(String paramString)
  {
    tlo.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + paramString);
    paramString = new the(new tkb(paramString), null, new teq(this), 4006);
    tgx.a().a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt)
  {
    tlo.b("WSUserBusiness", "[actionChangeFollow] personID : " + paramString + "  followStatus:" + paramInt);
    c(paramString, paramInt);
    paramString = new the(new tkc(paramString, paramInt), null, a(paramString, paramInt), 4005);
    tgx.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tep
 * JD-Core Version:    0.7.0.1
 */