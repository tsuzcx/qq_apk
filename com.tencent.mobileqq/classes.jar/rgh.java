import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import org.xmlpull.v1.XmlSerializer;

public class rgh
  extends StructMsgItemCover
{
  public rgh(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    super(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.u == null) {}
    for (String str = "";; str = this.u)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgh
 * JD-Core Version:    0.7.0.1
 */