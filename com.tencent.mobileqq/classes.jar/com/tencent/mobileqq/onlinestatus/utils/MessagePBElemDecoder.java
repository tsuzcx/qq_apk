package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;

public class MessagePBElemDecoder
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 17	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 18	java/util/zip/Inflater:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 21	java/util/zip/Inflater:reset	()V
    //   12: aload_3
    //   13: aload_0
    //   14: invokevirtual 25	java/util/zip/Inflater:setInput	([B)V
    //   17: new 27	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: aload_0
    //   22: arraylength
    //   23: invokespecial 30	java/io/ByteArrayOutputStream:<init>	(I)V
    //   26: astore 4
    //   28: sipush 1024
    //   31: newarray byte
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 34	java/util/zip/Inflater:finished	()Z
    //   38: ifne +18 -> 56
    //   41: aload 4
    //   43: aload_1
    //   44: iconst_0
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 38	java/util/zip/Inflater:inflate	([B)I
    //   50: invokevirtual 42	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -19 -> 34
    //   56: aload 4
    //   58: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload 4
    //   66: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   69: aload_2
    //   70: astore_0
    //   71: goto +29 -> 100
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   79: aload_1
    //   80: astore_0
    //   81: goto +19 -> 100
    //   84: astore_0
    //   85: goto +21 -> 106
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 53	java/lang/Exception:printStackTrace	()V
    //   93: aload_0
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_3
    //   101: invokevirtual 56	java/util/zip/Inflater:end	()V
    //   104: aload_0
    //   105: areturn
    //   106: aload 4
    //   108: invokevirtual 49	java/io/ByteArrayOutputStream:close	()V
    //   111: goto +8 -> 119
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 52	java/io/IOException:printStackTrace	()V
    //   119: goto +5 -> 124
    //   122: aload_0
    //   123: athrow
    //   124: goto -2 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramArrayOfByte	byte[]
    //   33	47	1	localObject	Object
    //   88	2	1	localException	java.lang.Exception
    //   94	1	1	arrayOfByte1	byte[]
    //   114	2	1	localIOException	java.io.IOException
    //   61	9	2	arrayOfByte2	byte[]
    //   7	94	3	localInflater	java.util.zip.Inflater
    //   26	81	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   64	69	74	java/io/IOException
    //   95	100	74	java/io/IOException
    //   28	34	84	finally
    //   34	53	84	finally
    //   56	62	84	finally
    //   89	93	84	finally
    //   28	34	88	java/lang/Exception
    //   34	53	88	java/lang/Exception
    //   56	62	88	java/lang/Exception
    //   106	111	114	java/io/IOException
  }
  
  public String a(List<im_msg_body.Elem> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder("<---decodePbElems:");
    int m = paramList.size();
    int k = 0;
    int i;
    for (int j = 0; k < m; j = i)
    {
      Object localObject2 = (im_msg_body.Elem)paramList.get(k);
      if (((im_msg_body.Elem)localObject2).text.has()) {
        if (j != 0) {
          i = 0;
        }
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:Text;\n");
        }
        localStringBuilder1.length();
        Object localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get();
        i = j;
        if (((im_msg_body.Text)localObject1).str.has())
        {
          localStringBuilder1.append(MessageUtils.a(((im_msg_body.Text)localObject1).str.get().toStringUtf8(), false));
          i = j;
          continue;
          if (((im_msg_body.Elem)localObject2).face.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder2.append("elemType:Face;\n");
            }
            i = j;
            if (((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.has())
            {
              int n = QQSysFaceUtil.convertToLocal(((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.get());
              i = j;
              if (n >= 0)
              {
                localStringBuilder1.append('\024');
                localStringBuilder1.append((char)n);
                i = j;
              }
            }
          }
          else if (((im_msg_body.Elem)localObject2).small_emoji.has())
          {
            if (QLog.isColorLevel()) {
              localStringBuilder2.append("elemType:small_emoji;\n");
            }
            i = j;
            if (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.has())
            {
              i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
              j = ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.get() & 0xFFFF;
              localObject1 = EmosmUtils.b(i, j);
              if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
              {
                localObject1[3] = 511;
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("get apng epid = ");
                  ((StringBuilder)localObject2).append(i);
                  ((StringBuilder)localObject2).append(" eid = ");
                  ((StringBuilder)localObject2).append(j);
                  QLog.d("MessagePBElemDecoder", 2, ((StringBuilder)localObject2).toString());
                }
              }
              localStringBuilder1.append('\024');
              localStringBuilder1.append(localObject1[3]);
              localStringBuilder1.append(localObject1[2]);
              localStringBuilder1.append(localObject1[1]);
              localStringBuilder1.append(localObject1[0]);
              i = 1;
            }
          }
          else
          {
            i = j;
            if (((im_msg_body.Elem)localObject2).common_elem.has())
            {
              i = j;
              if (33 == ((im_msg_body.Elem)localObject2).common_elem.uint32_service_type.get())
              {
                if (QLog.isColorLevel()) {
                  localStringBuilder2.append("elemType:NewSysFaceMsg;\n");
                }
                localStringBuilder1.append(a((im_msg_body.CommonElem)((im_msg_body.Elem)localObject2).common_elem.get()));
                i = j;
              }
            }
          }
        }
      }
      k += 1;
    }
    return localStringBuilder1.toString();
  }
  
  public String a(im_msg_body.CommonElem paramCommonElem)
  {
    if ((paramCommonElem != null) && (paramCommonElem.bytes_pb_elem.has())) {
      try
      {
        hummer_commelem.MsgElemInfo_servtype33 localMsgElemInfo_servtype33 = new hummer_commelem.MsgElemInfo_servtype33();
        localMsgElemInfo_servtype33.mergeFrom(paramCommonElem.bytes_pb_elem.get().toByteArray());
        if (localMsgElemInfo_servtype33.bytes_text.has()) {
          localMsgElemInfo_servtype33.bytes_text.get().toStringUtf8();
        }
        int i = QQSysFaceUtil.convertToLocal(localMsgElemInfo_servtype33.uint32_index.get());
        if (i >= 0)
        {
          paramCommonElem = QQSysFaceUtil.getFaceString(i);
          return paramCommonElem;
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommonElem)
      {
        paramCommonElem.printStackTrace();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.MessagePBElemDecoder
 * JD-Core Version:    0.7.0.1
 */