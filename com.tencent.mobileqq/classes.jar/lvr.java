import android.graphics.Bitmap;
import com.tencent.av.random.RandomWebProtocol;

public class lvr
  extends lvn
{
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String b;
  String c;
  String d;
  String e;
  int f = 0;
  
  public lvr(RandomWebProtocol paramRandomWebProtocol)
  {
    this.jdField_c_of_type_Int = 5000;
    this.jdField_d_of_type_Int = 900;
  }
  
  /* Error */
  void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 34	lvn:a	(Ljava/lang/String;)V
    //   5: iconst_3
    //   6: aload_0
    //   7: getfield 36	lvn:jdField_a_of_type_Int	I
    //   10: if_icmpne +175 -> 185
    //   13: aload_0
    //   14: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   17: ifnull +168 -> 185
    //   20: aload_0
    //   21: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   24: ldc 41
    //   26: invokevirtual 47	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   29: ifeq +16 -> 45
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   37: ldc 41
    //   39: invokevirtual 51	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   42: putfield 24	lvr:f	I
    //   45: aload_0
    //   46: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   49: ldc 53
    //   51: invokevirtual 47	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +22 -> 76
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   62: ldc 53
    //   64: invokevirtual 57	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual 63	java/lang/String:trim	()Ljava/lang/String;
    //   70: invokestatic 67	bdhe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   73: putfield 69	lvr:b	Ljava/lang/String;
    //   76: aload_0
    //   77: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   80: ldc 71
    //   82: invokevirtual 47	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   85: ifeq +16 -> 101
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   93: ldc 71
    //   95: invokevirtual 57	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: putfield 73	lvr:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   101: aload_0
    //   102: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   105: ldc 75
    //   107: invokevirtual 47	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   110: ifeq +22 -> 132
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   118: ldc 75
    //   120: invokevirtual 57	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 67	bdhe:a	(Ljava/lang/String;)Ljava/lang/String;
    //   126: invokevirtual 63	java/lang/String:trim	()Ljava/lang/String;
    //   129: putfield 77	lvr:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   136: ldc 79
    //   138: invokevirtual 47	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   141: ifeq +16 -> 157
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   149: ldc 79
    //   151: invokevirtual 83	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   154: putfield 85	lvr:jdField_a_of_type_Long	J
    //   157: aload_0
    //   158: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   161: ldc 87
    //   163: invokevirtual 47	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   166: ifeq +19 -> 185
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 39	lvn:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   174: ldc 87
    //   176: invokevirtual 57	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: invokestatic 90	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;)Ljava/lang/String;
    //   182: putfield 92	lvr:e	Ljava/lang/String;
    //   185: iconst_1
    //   186: aload_0
    //   187: getfield 24	lvr:f	I
    //   190: if_icmpeq +19 -> 209
    //   193: iconst_3
    //   194: aload_0
    //   195: getfield 24	lvr:f	I
    //   198: if_icmpeq +11 -> 209
    //   201: iconst_4
    //   202: aload_0
    //   203: getfield 24	lvr:f	I
    //   206: if_icmpne +144 -> 350
    //   209: aload_0
    //   210: getfield 85	lvr:jdField_a_of_type_Long	J
    //   213: invokestatic 96	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   216: astore_2
    //   217: aload_2
    //   218: astore_1
    //   219: aload_2
    //   220: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifeq +14 -> 237
    //   226: aload_0
    //   227: getfield 19	lvr:jdField_a_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   230: invokestatic 105	com/tencent/av/random/RandomWebProtocol:a	(Lcom/tencent/av/random/RandomWebProtocol;)Lcom/tencent/av/app/VideoAppInterface;
    //   233: invokevirtual 110	com/tencent/av/app/VideoAppInterface:getAccount	()Ljava/lang/String;
    //   236: astore_1
    //   237: iconst_2
    //   238: aload_0
    //   239: getfield 24	lvr:f	I
    //   242: if_icmpne +8 -> 250
    //   245: aload_0
    //   246: getfield 92	lvr:e	Ljava/lang/String;
    //   249: astore_1
    //   250: aload_1
    //   251: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +32 -> 286
    //   257: aload_0
    //   258: getfield 69	lvr:b	Ljava/lang/String;
    //   261: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   264: ifne +22 -> 286
    //   267: aload_0
    //   268: getfield 19	lvr:jdField_a_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   271: invokestatic 105	com/tencent/av/random/RandomWebProtocol:a	(Lcom/tencent/av/random/RandomWebProtocol;)Lcom/tencent/av/app/VideoAppInterface;
    //   274: invokevirtual 113	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   277: aload_1
    //   278: aload_0
    //   279: getfield 69	lvr:b	Ljava/lang/String;
    //   282: iconst_1
    //   283: invokevirtual 118	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   286: aload_0
    //   287: getfield 73	lvr:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   290: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   293: ifne +40 -> 333
    //   296: aload_0
    //   297: getfield 73	lvr:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   300: ldc 120
    //   302: invokestatic 124	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   305: ifne +28 -> 333
    //   308: aload_0
    //   309: aload_0
    //   310: getfield 19	lvr:jdField_a_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   313: aload_1
    //   314: aload_0
    //   315: getfield 73	lvr:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   318: invokevirtual 127	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   321: putfield 129	lvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   324: return
    //   325: astore_1
    //   326: aload_1
    //   327: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   330: goto -145 -> 185
    //   333: aload_0
    //   334: aconst_null
    //   335: putfield 129	lvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   338: return
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   344: aload_0
    //   345: aconst_null
    //   346: putfield 129	lvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   349: return
    //   350: aconst_null
    //   351: astore_1
    //   352: goto -115 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	lvr
    //   0	355	1	paramString	String
    //   216	4	2	str	String
    // Exception table:
    //   from	to	target	type
    //   20	45	325	java/lang/Exception
    //   45	76	325	java/lang/Exception
    //   76	101	325	java/lang/Exception
    //   101	132	325	java/lang/Exception
    //   132	157	325	java/lang/Exception
    //   157	185	325	java/lang/Exception
    //   185	209	339	java/lang/Exception
    //   209	217	339	java/lang/Exception
    //   219	237	339	java/lang/Exception
    //   237	250	339	java/lang/Exception
    //   250	286	339	java/lang/Exception
    //   286	324	339	java/lang/Exception
    //   333	338	339	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lvr
 * JD-Core Version:    0.7.0.1
 */