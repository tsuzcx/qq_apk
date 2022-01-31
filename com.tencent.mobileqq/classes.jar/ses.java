import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;

public class ses
  extends AVObserver
{
  public ses(Conversation paramConversation) {}
  
  protected void a(int paramInt, long paramLong)
  {
    paramInt = UITools.b(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = UITools.b(paramInt);
    this.a.a(8, Long.toString(paramLong1), paramInt);
    this.a.b(paramLong1);
    this.a.a(new set(this, paramLong1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.a(new sew(this));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    this.a.a(new sey(this));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.a.a(new sex(this));
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void b(int paramInt, long paramLong)
  {
    paramInt = UITools.b(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.getCurrentAccountUin()).longValue()) {
      this.a.a(new seu(this, paramLong1));
    }
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.getCurrentAccountUin()).longValue()) {
      this.a.a(new sev(this, paramLong1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ses
 * JD-Core Version:    0.7.0.1
 */