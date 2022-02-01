package com.tencent.mobileqq.kandian.repo.follow;

public class FollowingMember
{
  private Long a;
  private String b;
  private String c;
  private Integer d;
  private boolean e;
  
  public Long a()
  {
    return this.a;
  }
  
  public void a(Integer paramInteger)
  {
    this.d = paramInteger;
  }
  
  public void a(Long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FollowingMember{uin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickname='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowingMember
 * JD-Core Version:    0.7.0.1
 */