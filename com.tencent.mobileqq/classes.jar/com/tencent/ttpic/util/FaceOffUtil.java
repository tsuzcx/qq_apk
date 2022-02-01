package com.tencent.ttpic.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.graphics.PointF;>;

public class FaceOffUtil
{
  private static final String COORDS_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
  private static final String COORDS_FILE_FACE_COS3D_MASK = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_FACE_HEAD_CROP = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
  private static final String COORDS_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
  private static final String COORDS_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_MASK = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_NO_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  public static final Float[] COSMETIC_MODEL_IMAGE_FACEPOINTS;
  public static final int COSMETIC_MODEL_IMAGE_HEIGHT = 1067;
  public static final int COSMETIC_MODEL_IMAGE_WIDTH = 800;
  private static String DEFAULT_BRUSH_POINT = "assets://camera/camera_video/defaultmask/default_brush_point.png";
  private static PointF EMPTY_POINT = new PointF();
  public static final int[] FaceMeshTriangles;
  public static final int[] FaceMeshTrianglesFaceAverage;
  public static final int[] FaceMeshTrianglesFaceAverageForTypeOne;
  public static final int[] FaceMeshTriangles_v2;
  public static String GRAY_CRAZY_SKIN_MERGE_MASK_NAME = "defaultMaskImage.jpg";
  private static String GRAY_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/grayImages/crazyfacegray.png";
  private static String GRAY_FILE_CROP_HEAD_FACE = "assets://camera/camera_video/faceOff/grayImages/faceheadcropgray.png";
  private static String GRAY_FILE_FACE_COS3D_MASK = "assets://camera/camera_video/faceOff/grayImages/faceMaskCos3D.png";
  private static String GRAY_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/grayImages/faceMask_skin.png";
  private static String GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
  private static String GRAY_FILE_LIPS_MASK = "assets://realtimeBeauty/lipsMask.png";
  private static String GRAY_FILE_MASK = "assets://camera/camera_video/faceOff/grayImages/faceoffmask.png";
  public static String GRAY_FILE_NOSE_MASK = "assets://camera/camera_video/faceOff/grayImages/faceoffnose.png";
  private static String GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
  public static final int IRIS_TRIANGLE_COUNT = 8;
  public static final int[] IrisMeshTriangles = { 0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 1, 5, 6, 7, 5, 7, 8, 5, 8, 9, 5, 9, 6 };
  public static final int NO_HOLE_TRIANGLE_COUNT = 230;
  public static int NO_HOLE_TRIANGLE_COUNT_4_SMOOTH = 0;
  public static final int NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE = 184;
  public static final int NO_HOLE_TRIANGLE_COUNT_V2;
  public static final int NO_HOLE_VERTEX_COUNT_V2 = 135;
  public static int[] Select3DIndices = { 359, 365, 364, 388, 2082, 393, 11, 21, 2161, 33, 466, 464, 1771, 874, 2085, 802, 2081, 782, 2591, 1203, 231, 2667, 2086, 162, 1071, 1059, 167, 1204, 664, 2669, 2091, 595, 1072, 1060, 600, 200, 214, 213, 253, 181, 191, 1454, 3034, 3023, 397, 633, 647, 646, 685, 614, 624, 1455, 3035, 3027, 811, 2649, 2894, 3144, 93, 3038, 530, 3147, 2895, 2652, 3432, 1586, 3309, 3059, 264, 411, 693, 3060, 1427, 3375, 1426, 314, 3176, 3208, 3178, 735, 3173, 1600, 1450, 211, 2361, 185, 182, 198, 2584, 2778, 1041, 2780, 194, 644, 2365, 618, 615, 631, 2587, 2783, 1042, 2785, 627 };
  private static final String TAG = "FaceOffUtil";
  private static Bitmap crazySkinMergeBitmap;
  public static final int[] faceMesh4Smooth;
  public static final int[] faceMeshNoseLastTriangles;
  
  static
  {
    Float localFloat1 = Float.valueOf(528.13641F);
    Float localFloat2 = Float.valueOf(595.37152F);
    Float localFloat3 = Float.valueOf(460.90134F);
    Float localFloat4 = Float.valueOf(508.64798F);
    Float localFloat5 = Float.valueOf(512.54565F);
    Float localFloat6 = Float.valueOf(400.48721F);
    Float localFloat7 = Float.valueOf(713.27649F);
    COSMETIC_MODEL_IMAGE_FACEPOINTS = new Float[] { Float.valueOf(156.88185F), localFloat1, Float.valueOf(169.54933F), localFloat2, Float.valueOf(181.24239F), Float.valueOf(649.93909F), Float.valueOf(191.96103F), Float.valueOf(695.73688F), Float.valueOf(214.37271F), Float.valueOf(738.61145F), Float.valueOf(238.73325F), Float.valueOf(776.61389F), Float.valueOf(277.71011F), Float.valueOf(811.69305F), Float.valueOf(311.81485F), Float.valueOf(843.84894F), Float.valueOf(351.76614F), Float.valueOf(868.20947F), Float.valueOf(398.53836F), Float.valueOf(876.97931F), Float.valueOf(445.31061F), Float.valueOf(866.26068F), Float.valueOf(491.1084F), Float.valueOf(841.90015F), localFloat1, Float.valueOf(807.79535F), Float.valueOf(558.34351F), Float.valueOf(769.79291F), Float.valueOf(585.62726F), Float.valueOf(734.71375F), Float.valueOf(605.11572F), Float.valueOf(690.86481F), Float.valueOf(618.75763F), Float.valueOf(645.06702F), Float.valueOf(630.45068F), Float.valueOf(592.44824F), Float.valueOf(633.37396F), Float.valueOf(524.23871F), Float.valueOf(199.75639F), Float.valueOf(446.285F), Float.valueOf(239.70767F), Float.valueOf(444.33618F), Float.valueOf(280.63336F), Float.valueOf(448.23386F), Float.valueOf(321.55908F), Float.valueOf(456.02924F), Float.valueOf(362.48477F), Float.valueOf(458.95248F), Float.valueOf(327.40561F), Float.valueOf(433.61755F), Float.valueOf(283.55664F), Float.valueOf(425.82217F), Float.valueOf(239.70767F), Float.valueOf(425.82217F), localFloat2, Float.valueOf(445.31061F), Float.valueOf(555.42023F), Float.valueOf(444.33618F), Float.valueOf(515.46893F), Float.valueOf(452.13156F), Float.valueOf(484.28745F), Float.valueOf(457.00366F), Float.valueOf(438.48965F), localFloat3, Float.valueOf(464.79901F), Float.valueOf(435.56638F), localFloat4, Float.valueOf(422.8989F), Float.valueOf(559.31793F), Float.valueOf(422.8989F), Float.valueOf(241.65651F), Float.valueOf(506.69916F), Float.valueOf(260.17053F), Float.valueOf(518.39221F), Float.valueOf(285.50549F), Float.valueOf(522.28992F), Float.valueOf(309.86603F), Float.valueOf(520.34106F), Float.valueOf(336.17538F), Float.valueOf(511.57126F), Float.valueOf(317.66138F), Float.valueOf(493.05725F), Float.valueOf(287.45432F), Float.valueOf(483.31302F), Float.valueOf(263.09378F), Float.valueOf(489.15958F), Float.valueOf(291.35202F), Float.valueOf(504.75031F), Float.valueOf(291.35202F), Float.valueOf(502.80145F), Float.valueOf(558.34351F), Float.valueOf(501.82703F), Float.valueOf(537.88062F), Float.valueOf(516.44336F), Float.valueOf(511.57126F), Float.valueOf(523.26428F), Float.valueOf(487.21072F), Float.valueOf(521.31549F), localFloat3, localFloat5, Float.valueOf(481.3642F), Float.valueOf(492.08282F), localFloat4, Float.valueOf(484.28745F), Float.valueOf(534.9574F), Float.valueOf(488.18515F), localFloat4, Float.valueOf(502.80145F), localFloat4, Float.valueOf(500.85263F), Float.valueOf(370.28015F), localFloat5, Float.valueOf(366.38245F), Float.valueOf(600.24359F), Float.valueOf(340.07309F), Float.valueOf(649.93909F), Float.valueOf(370.28015F), Float.valueOf(668.45313F), localFloat6, Float.valueOf(672.35077F), Float.valueOf(428.74542F), Float.valueOf(666.50427F), Float.valueOf(458.95248F), Float.valueOf(647.01581F), Float.valueOf(432.64313F), Float.valueOf(601.21802F), Float.valueOf(430.69427F), Float.valueOf(513.52008F), localFloat6, Float.valueOf(636.29718F), Float.valueOf(312.78928F), Float.valueOf(719.12305F), Float.valueOf(489.15958F), Float.valueOf(717.17419F), Float.valueOf(335.20099F), Float.valueOf(743.48358F), Float.valueOf(364.43362F), Float.valueOf(759.07428F), Float.valueOf(399.51279F), Float.valueOf(766.86969F), Float.valueOf(434.59195F), Float.valueOf(758.09985F), Float.valueOf(464.79901F), Float.valueOf(741.53473F), Float.valueOf(442.38733F), Float.valueOf(736.6626F), Float.valueOf(401.46164F), Float.valueOf(741.53473F), Float.valueOf(352.74057F), Float.valueOf(736.6626F), Float.valueOf(346.89404F), localFloat7, Float.valueOf(379.04993F), Float.valueOf(710.35321F), Float.valueOf(401.46164F), Float.valueOf(714.25092F), Float.valueOf(421.92447F), localFloat7, Float.valueOf(454.08038F), localFloat7, Float.valueOf(442.38733F), Float.valueOf(729.84167F), localFloat6, Float.valueOf(731.79053F), Float.valueOf(354.68939F), Float.valueOf(727.89282F), localFloat6, localFloat5, Float.valueOf(404.38489F), localFloat3, localFloat6, Float.valueOf(692.81366F), Float.valueOf(205.60292F), Float.valueOf(205.60292F), Float.valueOf(398.53836F), Float.valueOf(275.76126F), Float.valueOf(598.29474F), Float.valueOf(197.80756F), localFloat6, Float.valueOf(356.63824F) };
    FaceMeshTrianglesFaceAverage = new int[] { 0, 1, 35, 1, 35, 36, 35, 36, 42, 20, 35, 42, 19, 20, 35, 19, 20, 26, 19, 26, 96, 19, 90, 96, 26, 95, 96, 25, 26, 95, 21, 25, 26, 20, 21, 26, 20, 21, 42, 21, 41, 42, 41, 42, 43, 36, 42, 43, 36, 37, 43, 36, 37, 57, 2, 36, 57, 2, 3, 57, 3, 4, 65, 4, 5, 65, 5, 65, 67, 5, 6, 67, 6, 7, 67, 7, 67, 68, 7, 8, 68, 8, 68, 69, 68, 69, 73, 68, 73, 74, 67, 68, 74, 65, 67, 74, 65, 75, 82, 57, 58, 75, 58, 75, 76, 75, 76, 82, 65, 74, 82, 74, 81, 82, 73, 74, 81, 70, 72, 73, 69, 70, 73, 10, 69, 70, 9, 10, 69, 8, 9, 69, 10, 11, 70, 12, 13, 71, 13, 66, 71, 13, 14, 66, 14, 15, 66, 60, 61, 79, 59, 60, 64, 59, 60, 78, 59, 77, 78, 76, 77, 81, 59, 76, 77, 58, 59, 76, 58, 59, 64, 56, 58, 64, 56, 57, 58, 37, 38, 43, 38, 40, 43, 38, 39, 40, 38, 39, 56, 39, 55, 56, 23, 39, 55, 56, 62, 64, 47, 61, 62, 46, 47, 61, 15, 16, 61, 17, 45, 46, 17, 18, 45, 27, 28, 45, 28, 45, 52, 28, 29, 52, 29, 51, 52, 29, 50, 51, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 48, 62, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 32, 94, 32, 92, 94, 32, 33, 92, 29, 30, 50, 27, 28, 34, 27, 34, 93, 27, 91, 93, 34, 92, 93, 33, 34, 92, 23, 31, 94, 23, 24, 94, 22, 23, 24, 21, 22, 24, 40, 41, 43, 22, 39, 40, 22, 23, 39, 21, 24, 25, 24, 25, 95, 24, 94, 95, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 79, 80, 66, 71, 72, 70, 71, 72, 60, 78, 79, 1, 2, 36, 95, 96, 99, 92, 93, 105, 91, 104, 105, 14, 103, 104, 11, 102, 103, 7, 101, 102, 4, 100, 101, 90, 99, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 105, 106, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 96, 99, 0, 90, 100, 21, 40, 41, 21, 22, 40, 23, 31, 83, 23, 55, 83, 31, 63, 83, 55, 56, 83, 56, 62, 83, 62, 63, 83, 49, 62, 63, 48, 49, 62, 30, 31, 49, 30, 49, 50, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 52, 53, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 62, 64, 60, 61, 62, 16, 46, 61, 16, 17, 46, 77, 78, 81, 78, 80, 81, 72, 80, 81, 72, 73, 81, 11, 70, 71, 11, 12, 71, 0, 19, 90, 0, 19, 35, 18, 27, 91, 18, 27, 45, 3, 57, 65, 57, 65, 75, 61, 66, 79, 15, 61, 66 };
    FaceMeshTrianglesFaceAverageForTypeOne = new int[] { 0, 35, 1, 1, 35, 36, 35, 42, 36, 20, 42, 35, 19, 20, 35, 19, 26, 20, 19, 96, 26, 19, 90, 96, 26, 96, 95, 25, 26, 95, 21, 26, 25, 20, 26, 21, 20, 21, 42, 21, 41, 42, 41, 43, 42, 36, 42, 43, 36, 43, 37, 36, 37, 57, 2, 36, 57, 2, 57, 3, 3, 65, 4, 4, 65, 5, 5, 65, 67, 5, 67, 6, 6, 67, 7, 7, 67, 68, 7, 68, 8, 8, 68, 69, 68, 73, 69, 68, 74, 73, 67, 74, 68, 65, 74, 67, 65, 75, 82, 57, 58, 75, 58, 76, 75, 75, 76, 82, 65, 82, 74, 74, 82, 81, 73, 74, 81, 70, 73, 72, 69, 73, 70, 10, 69, 70, 9, 69, 10, 8, 69, 9, 10, 70, 11, 12, 71, 13, 13, 71, 66, 13, 66, 14, 14, 66, 15, 60, 61, 79, 59, 64, 60, 59, 60, 78, 59, 78, 77, 76, 77, 81, 59, 77, 76, 58, 59, 76, 58, 64, 59, 56, 64, 58, 56, 58, 57, 37, 43, 38, 38, 43, 40, 38, 40, 39, 38, 39, 56, 39, 55, 56, 23, 55, 39, 56, 62, 64, 47, 61, 62, 46, 61, 47, 15, 61, 16, 17, 46, 45, 17, 45, 18, 27, 45, 28, 28, 45, 52, 28, 52, 29, 29, 52, 51, 30, 51, 50, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 62, 48, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 94, 32, 32, 94, 92, 32, 92, 33, 29, 51, 30, 27, 28, 34, 27, 34, 93, 27, 93, 91, 34, 92, 93, 33, 92, 34, 23, 94, 31, 23, 24, 94, 22, 24, 23, 21, 24, 22, 40, 43, 41, 22, 40, 41, 22, 23, 40, 21, 25, 24, 24, 25, 95, 24, 95, 94, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 80, 79, 66, 71, 72, 70, 72, 71, 60, 79, 78, 1, 36, 2, 95, 96, 99, 92, 105, 93, 91, 105, 104, 14, 104, 103, 11, 103, 102, 7, 102, 101, 4, 101, 100, 90, 100, 99, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 106, 105, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 99, 96, 0, 100, 90, 23, 39, 40, 21, 22, 41, 23, 31, 83, 23, 83, 55, 31, 63, 83, 55, 83, 56, 56, 83, 62, 62, 83, 63, 49, 62, 63, 48, 62, 49, 30, 50, 31, 31, 50, 49, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 53, 52, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 64, 62, 60, 62, 61, 16, 61, 46, 16, 46, 17, 77, 78, 81, 78, 80, 81, 72, 81, 80, 72, 73, 81, 11, 70, 71, 11, 71, 12, 0, 90, 19, 0, 19, 35, 18, 27, 91, 18, 45, 27, 3, 57, 65, 57, 75, 65, 61, 66, 79, 15, 66, 61 };
    FaceMeshTriangles = new int[] { 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 58, 64, 59, 64, 58, 57, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 61, 64, 62, 64, 61, 60, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 84, 63, 83, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 64, 60, 59, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 83, 56, 55, 56, 83, 62, 64, 57, 56, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 56, 62, 64, 124, 125, 49, 63, 62, 83, 83, 55, 84, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100 };
    faceMesh4Smooth = new int[] { 131, 19, 26, 131, 26, 25, 131, 25, 133, 99, 131, 134, 106, 131, 133, 106, 131, 99, 19, 134, 131, 132, 105, 135, 106, 132, 105, 106, 132, 133, 132, 33, 133, 132, 34, 33, 132, 27, 34, 132, 27, 135, 133, 25, 24, 133, 24, 84, 133, 32, 84, 133, 33, 32, 0, 19, 134, 99, 134, 100, 100, 134, 0, 104, 18, 135, 105, 104, 135, 18, 27, 135, 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 107, 57, 65, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 124, 125, 49, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64, 0, 111, 19, 18, 121, 27, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 101, 4, 101, 4, 5, 101, 5, 6, 101, 6, 7, 101, 102, 7, 102, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 103, 11, 103, 11, 12, 103, 12, 13, 103, 13, 14, 103, 104, 14, 104, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18 };
    NO_HOLE_TRIANGLE_COUNT_4_SMOOTH = faceMesh4Smooth.length / 3;
    faceMeshNoseLastTriangles = new int[] { 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 124, 125, 49, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64 };
    FaceMeshTriangles_v2 = new int[] { 108, 14, 13, 108, 13, 12, 108, 12, 11, 134, 11, 66, 134, 11, 108, 71, 11, 66, 71, 11, 70, 107, 4, 5, 107, 5, 6, 107, 6, 7, 133, 7, 65, 133, 7, 107, 67, 7, 65, 67, 7, 68, 19, 118, 111, 118, 19, 20, 69, 8, 68, 8, 69, 9, 58, 76, 75, 76, 58, 59, 65, 75, 82, 65, 67, 74, 65, 82, 74, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 10, 9, 69, 11, 10, 70, 36, 113, 112, 113, 36, 37, 41, 119, 40, 119, 41, 117, 37, 41, 38, 41, 37, 42, 42, 118, 120, 118, 42, 35, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 19, 111, 90, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 59, 60, 78, 124, 63, 125, 63, 124, 62, 124, 125, 49, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100, 0, 109, 111, 109, 112, 111, 131, 109, 112, 131, 112, 113, 131, 113, 114, 131, 114, 56, 0, 1, 109, 1, 2, 109, 2, 109, 107, 2, 107, 3, 3, 107, 4, 131, 56, 57, 133, 57, 65, 131, 57, 107, 131, 107, 109, 57, 107, 133, 18, 110, 121, 110, 122, 121, 132, 110, 122, 132, 122, 123, 132, 123, 124, 132, 124, 62, 18, 17, 110, 17, 16, 110, 16, 110, 108, 16, 108, 15, 15, 108, 14, 132, 62, 61, 134, 61, 66, 132, 61, 108, 132, 108, 110, 61, 108, 134, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64 };
    NO_HOLE_TRIANGLE_COUNT_V2 = FaceMeshTriangles_v2.length / 3;
  }
  
  private static float[] calcFullProbability_v2(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    PointF localPointF1 = (PointF)paramList.get(64);
    localPointF1 = (PointF)paramList.get(65);
    localPointF1 = (PointF)paramList.get(66);
    localPointF1 = (PointF)paramList.get(54);
    PointF localPointF2 = (PointF)paramList.get(44);
    localPointF1 = new PointF(localPointF1.x - localPointF2.x, localPointF1.y - localPointF2.y);
    localPointF2 = new PointF(-localPointF1.y, localPointF1.x);
    if (localPointF2.y < 0.0F)
    {
      localPointF2.x = (-localPointF2.x);
      localPointF2.y = (-localPointF2.y);
    }
    float f1 = AlgoUtils.getDistance(localPointF1, new PointF(0.0F, 0.0F));
    float f2 = AlgoUtils.getDistance(localPointF2, new PointF(0.0F, 0.0F));
    localPointF1.x /= f1;
    localPointF1.y /= f1;
    localPointF2.x /= f2;
    localPointF2.y /= f2;
    localPointF2 = (PointF)paramList.get(56);
    PointF localPointF3 = (PointF)paramList.get(62);
    PointF localPointF4 = (PointF)paramList.get(17);
    PointF localPointF5 = (PointF)paramList.get(1);
    PointF localPointF6 = (PointF)paramList.get(9);
    paramList = (PointF)paramList.get(87);
    Math.abs(localPointF1.x * (localPointF4.x - localPointF2.x) + localPointF1.y * (localPointF4.y - localPointF2.y));
    Math.abs(localPointF1.x * (localPointF5.x - localPointF3.x) + localPointF1.y * (localPointF5.y - localPointF3.y));
    paramList = new float[''];
    int i = 0;
    while (i < 90)
    {
      paramList[i] = paramArrayOfFloat[i];
      i += 1;
    }
    paramList[90] = paramList[1];
    paramList[91] = paramList[17];
    paramList[92] = 1.0F;
    paramList[93] = 1.0F;
    paramList[94] = 1.0F;
    paramList[95] = 1.0F;
    paramList[96] = 1.0F;
    paramList[97] = 0.0F;
    paramList[98] = 0.0F;
    paramList[99] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[100] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[101] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[102] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[103] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[104] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[105] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[106] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[107] = paramList[35];
    paramList[108] = paramList[45];
    paramList[109] = paramList[35];
    paramList[110] = paramList[45];
    paramList[111] = paramList[35];
    paramList[112] = paramList[36];
    paramList[113] = paramList[37];
    paramList[114] = paramList[38];
    paramList[115] = paramList[39];
    paramList[116] = paramList[40];
    paramList[117] = paramList[41];
    paramList[118] = paramList[42];
    paramList[119] = ((paramList[116] + paramList[117]) / 2.0F);
    paramList[120] = ((paramList[117] + paramList[118]) / 2.0F);
    paramList[121] = paramList[45];
    paramList[122] = paramList[46];
    paramList[123] = paramList[47];
    paramList[124] = paramList[48];
    paramList[125] = paramList[49];
    paramList[126] = paramList[50];
    paramList[127] = paramList[51];
    paramList[''] = paramList[52];
    paramList[''] = ((paramList[126] + paramList[127]) / 2.0F);
    paramList[''] = ((paramList[127] + paramList['']) / 2.0F);
    double d;
    if (paramFloat < 0.0F)
    {
      d = paramFloat;
      f2 = 0.7F - (float)(Math.cos(d) * 0.2D);
      f1 = (float)(Math.cos(d) * 2.0D) - 1.5F;
    }
    else
    {
      d = paramFloat;
      f2 = (float)(Math.cos(d) * 2.0D) - 1.5F;
      f1 = 0.7F - (float)(Math.cos(d) * 0.2D);
    }
    Math.max(Math.min(f2, 1.0F), 0.0F);
    Math.max(Math.min(f1, 1.0F), 0.0F);
    paramList[''] = paramList[36];
    paramList[''] = paramList[46];
    if (paramFloat < 0.0F)
    {
      d = paramFloat;
      paramFloat = (float)(Math.cos(d) * 0.2D);
      f1 = (float)(Math.cos(d) * 2.0D) - 1.5F;
      paramFloat = 0.7F - paramFloat;
    }
    else
    {
      d = paramFloat;
      paramFloat = (float)(Math.cos(d) * 2.0D) - 1.5F;
      f1 = 0.7F - (float)(Math.cos(d) * 0.2D);
    }
    Math.max(Math.min(paramFloat, 1.0F), 0.0F);
    Math.max(Math.min(f1, 1.0F), 0.0F);
    paramList[''] = paramList[36];
    paramList[''] = paramList[46];
    return paramList;
  }
  
  public static List<PointF> genPoints(List<Float> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      int j = i * 2;
      localArrayList.add(new PointF(((Float)paramList.get(j)).floatValue(), ((Float)paramList.get(j + 1)).floatValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<PointF> genPointsDouble(List<Double> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      int j = i * 2;
      localArrayList.add(new PointF(((Double)paramList.get(j)).floatValue(), ((Double)paramList.get(j + 1)).floatValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Bitmap getCrazySkinMergeMask(String paramString)
  {
    if (!BitmapUtils.isLegal(crazySkinMergeBitmap))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(GRAY_CRAZY_SKIN_MERGE_MASK_NAME);
      paramString = localStringBuilder.toString();
      crazySkinMergeBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
    }
    return crazySkinMergeBitmap;
  }
  
  public static void getCropNormalFaceFeature(List<PointF> paramList)
  {
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    float f3 = 1.0F / f1;
    float f4 = 1.0F / f2;
    int i = 0;
    while (i < paramList.size())
    {
      float f5 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(101), f2, (PointF)paramList.get(i));
      float f6 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(105), f1, (PointF)paramList.get(i));
      ((PointF)paramList.get(i)).set(f5 * f3, f6 * f4);
      i += 1;
    }
  }
  
  public static Bitmap getFaceBitmap(String paramString)
  {
    return getFaceBitmap(paramString, 2147483647, 2147483647);
  }
  
  public static Bitmap getFaceBitmap(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("/")) {
      paramString = BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, paramInt1, paramInt2);
    } else {
      paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), paramInt1, paramInt2);
    }
    if (!BitmapUtils.isLegal(paramString)) {
      return null;
    }
    return paramString;
  }
  
  public static Bitmap getFaceBitmap(String paramString, FaceItem paramFaceItem)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://")))
    {
      localObject = AEModule.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileUtils.getRealPath(paramString));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramFaceItem.faceExchangeImage);
      paramString = BitmapUtils.decodeSampledBitmapFromAssets((Context)localObject, localStringBuilder.toString(), 2147483647, 2147483647);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramFaceItem.faceExchangeImage);
      paramString = BitmapUtils.decodeSampledBitmapFromFile(((StringBuilder)localObject).toString(), 2147483647, 2147483647);
    }
    paramFaceItem = paramString;
    if (!BitmapUtils.isLegal(paramString)) {
      paramFaceItem = null;
    }
    return paramFaceItem;
  }
  
  public static List<PointF> getFacePoints4Smooth(List<PointF> paramList)
  {
    List localList = getFullCoordsForNoseAndOutline(paramList);
    PointF localPointF3 = new PointF(((PointF)paramList.get(35)).x + (((PointF)paramList.get(83)).x - ((PointF)paramList.get(59)).x) * 1.5F, ((PointF)paramList.get(35)).y + (((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y) * 1.5F);
    PointF localPointF1 = new PointF(((PointF)paramList.get(45)).x + (((PointF)paramList.get(83)).x - ((PointF)paramList.get(59)).x) * 1.5F, ((PointF)paramList.get(45)).y + (((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y) * 1.5F);
    PointF localPointF4 = (PointF)localList.get(0);
    PointF localPointF2 = (PointF)localList.get(18);
    localList.add(localPointF3);
    localList.add(localPointF1);
    PointF localPointF5 = AlgoUtils.middlePoint(localPointF3, localPointF1);
    float f1 = AlgoUtils.getDistance((PointF)localList.get(83), localPointF3) * 0.5F + AlgoUtils.getDistance((PointF)localList.get(83), localPointF1) * 0.5F;
    float f5 = AlgoUtils.getDistance((PointF)localList.get(83), localPointF5);
    float f2 = ((PointF)paramList.get(83)).x;
    float f3 = localPointF5.x;
    float f4 = ((PointF)paramList.get(83)).x;
    f5 += 1.0E-004F;
    localList.add(new PointF(f2 + (f3 - f4) * f1 / f5, ((PointF)paramList.get(83)).y + (localPointF5.y - ((PointF)paramList.get(83)).y) * f1 / f5));
    localPointF5 = AlgoUtils.middlePoint(localPointF3, localPointF4);
    f1 = AlgoUtils.getDistance((PointF)localList.get(83), localPointF3) * 0.5F + AlgoUtils.getDistance((PointF)localList.get(83), localPointF4) * 0.5F;
    f5 = AlgoUtils.getDistance((PointF)localList.get(83), localPointF5);
    f2 = ((PointF)paramList.get(83)).x;
    f3 = localPointF5.x;
    f4 = ((PointF)paramList.get(83)).x;
    f5 += 1.0E-004F;
    localList.add(new PointF(f2 + (f3 - f4) * f1 / f5, ((PointF)paramList.get(83)).y + (localPointF5.y - ((PointF)paramList.get(83)).y) * f1 / f5));
    localPointF3 = AlgoUtils.middlePoint(localPointF2, localPointF1);
    f1 = AlgoUtils.getDistance((PointF)localList.get(83), localPointF2) * 0.5F + AlgoUtils.getDistance((PointF)localList.get(83), localPointF1) * 0.5F;
    f5 = AlgoUtils.getDistance((PointF)localList.get(83), localPointF3);
    f2 = ((PointF)paramList.get(83)).x;
    f3 = localPointF3.x;
    f4 = ((PointF)paramList.get(83)).x;
    f5 += 1.0E-004F;
    localList.add(new PointF(f2 + (f3 - f4) * f1 / f5, ((PointF)paramList.get(83)).y + (localPointF3.y - ((PointF)paramList.get(83)).y) * f1 / f5));
    return localList;
  }
  
  public static FaceOffUtil.FeatureType getFeatureType(int paramInt)
  {
    FaceOffUtil.FeatureType[] arrayOfFeatureType = FaceOffUtil.FeatureType.values();
    int j = arrayOfFeatureType.length;
    int i = 0;
    while (i < j)
    {
      FaceOffUtil.FeatureType localFeatureType = arrayOfFeatureType[i];
      if (localFeatureType.value == paramInt) {
        return localFeatureType;
      }
      i += 1;
    }
    return FaceOffUtil.FeatureType.NO_EYE;
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      PointF localPointF3 = (PointF)paramList.get(83);
      double d1 = Math.atan((((PointF)paramList.get(9)).x - ((PointF)paramList.get(83)).x) / (-((PointF)paramList.get(9)).y + ((PointF)paramList.get(83)).y));
      float f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
      double d3 = ((PointF)paramList.get(1)).x;
      double d2 = f1 * 2.0F;
      double d4 = Math.sin(d1);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(1)).y;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF1 = new PointF(f1, (float)(d3 - d2 * d4));
      paramList.add(localPointF1);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
      d3 = ((PointF)paramList.get(17)).x;
      d2 = f1 * 2.0F;
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(17)).y;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF2 = new PointF(f1, (float)(d3 - d2 * d4));
      paramList.add(localPointF2);
      d2 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF3);
      Double.isNaN(d2);
      f1 = (float)(d2 * 1.2D);
      d3 = ((PointF)paramList.get(59)).x;
      d2 = f1 * 2.0F;
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(59)).y;
      d1 = Math.cos(d1);
      Double.isNaN(d2);
      Double.isNaN(d3);
      localPointF3 = new PointF(f1, (float)(d3 - d2 * d1));
      int i = 2;
      while (i >= 1)
      {
        d1 = Math.toRadians(i * 30.0F);
        PointF localPointF4 = new PointF();
        d2 = localPointF3.x;
        d3 = localPointF3.x - localPointF2.x;
        d4 = Math.cos(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        localPointF4.x = ((float)(d2 - d3 * d4));
        d2 = localPointF2.y;
        d3 = localPointF2.y - localPointF3.y;
        d1 = Math.sin(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        localPointF4.y = ((float)(d2 - d3 * d1));
        paramList.add(localPointF4);
        i -= 1;
      }
      i = 3;
      while (i >= 1)
      {
        d1 = Math.toRadians(i * 30.0F);
        localPointF2 = new PointF();
        d2 = localPointF3.x;
        d3 = localPointF3.x - localPointF1.x;
        d4 = Math.cos(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        localPointF2.x = ((float)(d2 - d3 * d4));
        d2 = localPointF1.y;
        d3 = localPointF1.y - localPointF3.y;
        d1 = Math.sin(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        localPointF2.y = ((float)(d2 - d3 * d1));
        paramList.add(localPointF2);
        i -= 1;
      }
      paramList.add(EMPTY_POINT);
      paramList.add(EMPTY_POINT);
      localPointF1 = (PointF)paramList.get(64);
      localPointF2 = (PointF)paramList.get(54);
      localPointF3 = (PointF)paramList.get(44);
      localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
      localPointF2 = new PointF(localPointF2.x + localPointF2.x, localPointF2.y + localPointF2.y);
      localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
      paramList.add(new PointF(localPointF1.x - localPointF2.x - localPointF3.x, localPointF1.y - localPointF2.y - localPointF3.y));
      paramList.add(new PointF(localPointF1.x - localPointF2.x, localPointF1.y - localPointF2.y));
      paramList.add(new PointF(localPointF1.x - localPointF2.x + localPointF3.x, localPointF1.y - localPointF2.y + localPointF3.y));
      paramList.add(new PointF(localPointF1.x + localPointF3.x, localPointF1.y + localPointF3.y));
      paramList.add(new PointF(localPointF1.x + localPointF2.x + localPointF3.x, localPointF1.y + localPointF2.y + localPointF3.y));
      paramList.add(new PointF(localPointF1.x + localPointF2.x, localPointF1.y + localPointF2.y));
      paramList.add(new PointF(localPointF1.x + localPointF2.x - localPointF3.x, localPointF1.y + localPointF2.y - localPointF3.y));
      paramList.add(new PointF(localPointF1.x - localPointF3.x, localPointF1.y - localPointF3.y));
      localPointF1 = (PointF)paramList.get(3);
      localPointF1 = (PointF)paramList.get(15);
      localPointF1 = (PointF)paramList.get(65);
      localPointF1 = (PointF)paramList.get(66);
      localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = (PointF)paramList.get(2);
      localPointF1 = (PointF)paramList.get(16);
      localPointF1 = (PointF)paramList.get(39);
      localPointF1 = (PointF)paramList.get(49);
      localPointF1 = (PointF)paramList.get(57);
      localPointF1 = (PointF)paramList.get(61);
      localPointF1 = (PointF)paramList.get(35);
      localPointF1 = (PointF)paramList.get(45);
      localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = (PointF)paramList.get(37);
      localPointF1 = (PointF)paramList.get(44);
      i = 35;
      float f3;
      float f2;
      float f4;
      float f5;
      while (i < 39)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          f1 = localPointF2.x;
          d1 = localPointF2.y;
          d2 = localPointF2.y - localPointF1.y;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramList.add(new PointF(f1, (float)(d1 + d2 * 0.7D)));
        }
        else
        {
          f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          d1 = localPointF2.x;
          d2 = localPointF2.x - localPointF1.x;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f2 = (float)(d1 + d2 * 0.7D);
          f4 = localPointF1.x;
          f5 = localPointF1.y;
          f1 = f2;
          if (i == 35)
          {
            f1 = f2;
            if (f2 < ((PointF)paramList.get(0)).x) {
              f1 = ((PointF)paramList.get(0)).x;
            }
          }
          paramList.add(new PointF(f1, f3 * (f2 - f4) + f5));
        }
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      int j = paramList.size();
      i = 40;
      while (i < 43)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          f1 = localPointF2.x;
          d1 = localPointF2.y;
          d2 = localPointF2.y - localPointF1.y;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramList.add(new PointF(f1, (float)(d1 + d2 * 1.2D)));
        }
        else
        {
          f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          d1 = localPointF2.x;
          d2 = localPointF2.x - localPointF1.x;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f2 = (float)(d1 + d2 * 1.2D);
          paramList.add(new PointF(f2, f1 * (f2 - localPointF1.x) + localPointF1.y));
        }
        i += 1;
      }
      localPointF3 = (PointF)paramList.get(j);
      localPointF1 = (PointF)paramList.get(j + 1);
      localPointF2 = (PointF)paramList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
      localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = (PointF)paramList.get(54);
      i = 45;
      while (i < 49)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          f1 = localPointF2.x;
          d1 = localPointF2.y;
          d2 = localPointF2.y - localPointF1.y;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramList.add(new PointF(f1, (float)(d1 + d2 * 0.7D)));
        }
        else
        {
          f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          d1 = localPointF2.x;
          d2 = localPointF2.x - localPointF1.x;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f2 = (float)(d1 + d2 * 0.7D);
          f4 = localPointF1.x;
          f5 = localPointF1.y;
          if (i == 45)
          {
            f1 = f2;
            if (f2 > ((PointF)paramList.get(18)).x) {
              f1 = ((PointF)paramList.get(18)).x;
            }
          }
          else
          {
            f1 = f2;
          }
          paramList.add(new PointF(f1, f3 * (f2 - f4) + f5));
        }
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      j = paramList.size();
      i = 50;
      while (i < 53)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          f1 = localPointF2.x;
          d1 = localPointF2.y;
          d2 = localPointF2.y - localPointF1.y;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramList.add(new PointF(f1, (float)(d1 + d2 * 1.2D)));
        }
        else
        {
          f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          d1 = localPointF2.x;
          d2 = localPointF2.x - localPointF1.x;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f2 = (float)(d1 + d2 * 1.2D);
          paramList.add(new PointF(f2, f1 * (f2 - localPointF1.x) + localPointF1.y));
        }
        i += 1;
      }
      localPointF3 = (PointF)paramList.get(j);
      localPointF1 = (PointF)paramList.get(j + 1);
      localPointF2 = (PointF)paramList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
      localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      return paramList;
    }
    return new ArrayList();
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList, float paramFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      if (paramList.size() > 97) {
        paramList.subList(97, paramList.size()).clear();
      }
      if ((paramList.size() != 90) && (paramList.size() != 97)) {
        return paramList;
      }
      PointF localPointF1 = new PointF((((PointF)paramList.get(41)).x + ((PointF)paramList.get(51)).x) / 2.0F, (((PointF)paramList.get(41)).y + ((PointF)paramList.get(51)).y) / 2.0F);
      float f1 = ((PointF)paramList.get(9)).x;
      float f2 = ((PointF)paramList.get(84)).x;
      float f3 = -((PointF)paramList.get(9)).y;
      float f4 = ((PointF)paramList.get(84)).y;
      double d1 = Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D;
      Object localObject = new android.graphics.Matrix();
      ((android.graphics.Matrix)localObject).reset();
      ((android.graphics.Matrix)localObject).postTranslate(-localPointF1.x, -localPointF1.y);
      ((android.graphics.Matrix)localObject).postRotate((float)Math.toDegrees(-d1));
      ((android.graphics.Matrix)localObject).postTranslate(localPointF1.x, localPointF1.y);
      List localList = AlgoUtils.mapPoints(paramList, (android.graphics.Matrix)localObject);
      double d3;
      double d2;
      if (localList.size() == 90)
      {
        f1 = AlgoUtils.getDistance((PointF)localList.get(0), (PointF)localList.get(1));
        d3 = ((PointF)localList.get(1)).x;
        d2 = f1 * 2.0F;
        double d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)localList.get(1)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramList = new PointF(f1, (float)(d3 - d2 * d4));
        localList.add(paramList);
        f1 = AlgoUtils.getDistance((PointF)localList.get(17), (PointF)localList.get(18));
        d3 = ((PointF)localList.get(17)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)localList.get(17)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF3 = new PointF(f1, (float)(d3 - d2 * d4));
        localList.add(localPointF3);
        f1 = AlgoUtils.getDistance((PointF)localList.get(59), localPointF1);
        d3 = ((PointF)localList.get(59)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)localList.get(59)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF2 = new PointF(f1, (float)(d3 - d2 * d4));
        i = 2;
        double d5;
        while (i >= 1)
        {
          d2 = Math.toRadians(i * 30.0F);
          PointF localPointF4 = new PointF();
          d3 = localPointF2.x;
          d4 = localPointF2.x - localPointF3.x;
          d5 = Math.cos(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF4.x = ((float)(d3 - d4 * d5));
          d3 = localPointF3.y;
          d4 = localPointF3.y - localPointF2.y;
          d2 = Math.sin(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF4.y = ((float)(d3 - d4 * d2));
          localList.add(localPointF4);
          i -= 1;
        }
        i = 3;
        while (i >= 1)
        {
          d2 = Math.toRadians(i * 30.0F);
          localPointF3 = new PointF();
          d3 = localPointF2.x;
          d4 = localPointF2.x - paramList.x;
          d5 = Math.cos(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF3.x = ((float)(d3 - d4 * d5));
          d3 = paramList.y;
          d4 = paramList.y - localPointF2.y;
          d2 = Math.sin(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF3.y = ((float)(d3 - d4 * d2));
          localList.add(localPointF3);
          i -= 1;
        }
      }
      localList.add(EMPTY_POINT);
      localList.add(EMPTY_POINT);
      paramList = (PointF)localList.get(64);
      PointF localPointF2 = (PointF)localList.get(54);
      PointF localPointF3 = (PointF)localList.get(44);
      localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
      localPointF2 = new PointF(localPointF2.x * paramFloat, localPointF2.y * paramFloat);
      localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
      localList.add(new PointF(paramList.x - localPointF2.x - localPointF3.x, paramList.y - localPointF2.y - localPointF3.y));
      localList.add(new PointF(paramList.x - localPointF2.x, paramList.y - localPointF2.y));
      localList.add(new PointF(paramList.x - localPointF2.x + localPointF3.x, paramList.y - localPointF2.y + localPointF3.y));
      localList.add(new PointF(paramList.x + localPointF3.x, paramList.y + localPointF3.y));
      localList.add(new PointF(paramList.x + localPointF2.x + localPointF3.x, paramList.y + localPointF2.y + localPointF3.y));
      localList.add(new PointF(paramList.x + localPointF2.x, paramList.y + localPointF2.y));
      localList.add(new PointF(paramList.x + localPointF2.x - localPointF3.x, paramList.y + localPointF2.y - localPointF3.y));
      localList.add(new PointF(paramList.x - localPointF3.x, paramList.y - localPointF3.y));
      paramList = (PointF)localList.get(3);
      paramList = (PointF)localList.get(15);
      paramList = (PointF)localList.get(65);
      paramList = (PointF)localList.get(66);
      paramList = AlgoUtils.middlePoint((PointF)localList.get(3), (PointF)localList.get(65));
      localList.add(new PointF(paramList.x, paramList.y));
      paramList = AlgoUtils.middlePoint((PointF)localList.get(15), (PointF)localList.get(66));
      localList.add(new PointF(paramList.x, paramList.y));
      paramList = (PointF)localList.get(2);
      paramList = (PointF)localList.get(16);
      paramList = (PointF)localList.get(39);
      paramList = (PointF)localList.get(49);
      paramList = (PointF)localList.get(57);
      paramList = (PointF)localList.get(61);
      paramList = (PointF)localList.get(35);
      paramList = (PointF)localList.get(45);
      paramList = AlgoUtils.middlePoint((PointF)localList.get(35), (PointF)localList.get(57));
      localList.add(new PointF(paramList.x, paramList.y));
      paramList = AlgoUtils.middlePoint((PointF)localList.get(45), (PointF)localList.get(61));
      localList.add(new PointF(paramList.x, paramList.y));
      paramList = (PointF)localList.get(37);
      localPointF2 = (PointF)localList.get(44);
      int i = 35;
      paramList = (List<PointF>)localObject;
      while (i < 39)
      {
        localObject = (PointF)localList.get(i);
        if (Math.abs(((PointF)localObject).x - localPointF2.x) < 1.0D)
        {
          paramFloat = ((PointF)localObject).x;
          d2 = ((PointF)localObject).y;
          d3 = ((PointF)localObject).y - localPointF2.y;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localList.add(new PointF(paramFloat, (float)(d2 + d3 * 0.7D)));
        }
        else
        {
          f2 = (((PointF)localObject).y - localPointF2.y) / (((PointF)localObject).x - localPointF2.x);
          d2 = ((PointF)localObject).x;
          d3 = ((PointF)localObject).x - localPointF2.x;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f1 = (float)(d2 + d3 * 0.7D);
          f3 = localPointF2.x;
          f4 = localPointF2.y;
          if (i == 35)
          {
            paramFloat = f1;
            if (f1 < ((PointF)localList.get(0)).x) {
              paramFloat = ((PointF)localList.get(0)).x;
            }
          }
          else
          {
            paramFloat = f1;
          }
          localList.add(new PointF(paramFloat, f2 * (f1 - f3) + f4));
        }
        i += 1;
      }
      localObject = AlgoUtils.middlePoint((PointF)localList.get(39), (PointF)localList.get(55));
      localList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
      int j = localList.size();
      i = 40;
      while (i < 43)
      {
        localObject = (PointF)localList.get(i);
        if (Math.abs(((PointF)localObject).x - localPointF2.x) < 1.0D)
        {
          paramFloat = ((PointF)localObject).x;
          d2 = ((PointF)localObject).y;
          d3 = ((PointF)localObject).y - localPointF2.y;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localList.add(new PointF(paramFloat, (float)(d2 + d3 * 1.2D)));
        }
        else
        {
          paramFloat = (((PointF)localObject).y - localPointF2.y) / (((PointF)localObject).x - localPointF2.x);
          d2 = ((PointF)localObject).x;
          d3 = ((PointF)localObject).x - localPointF2.x;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f1 = (float)(d2 + d3 * 1.2D);
          localList.add(new PointF(f1, paramFloat * (f1 - localPointF2.x) + localPointF2.y));
        }
        i += 1;
      }
      localPointF3 = (PointF)localList.get(j);
      localObject = (PointF)localList.get(j + 1);
      localPointF2 = (PointF)localList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, (PointF)localObject);
      localObject = AlgoUtils.middlePoint(localPointF2, (PointF)localObject);
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      localList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
      localObject = (PointF)localList.get(54);
      i = 45;
      while (i < 49)
      {
        localPointF2 = (PointF)localList.get(i);
        if (Math.abs(localPointF2.x - ((PointF)localObject).x) < 1.0D)
        {
          paramFloat = localPointF2.x;
          d2 = localPointF2.y;
          d3 = localPointF2.y - ((PointF)localObject).y;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localList.add(new PointF(paramFloat, (float)(d2 + d3 * 0.7D)));
        }
        else
        {
          f2 = (localPointF2.y - ((PointF)localObject).y) / (localPointF2.x - ((PointF)localObject).x);
          d2 = localPointF2.x;
          d3 = localPointF2.x - ((PointF)localObject).x;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f1 = (float)(d2 + d3 * 0.7D);
          f3 = ((PointF)localObject).x;
          f4 = ((PointF)localObject).y;
          paramFloat = f1;
          if (i == 45)
          {
            paramFloat = f1;
            if (f1 > ((PointF)localList.get(18)).x) {
              paramFloat = ((PointF)localList.get(18)).x;
            }
          }
          localList.add(new PointF(paramFloat, f2 * (f1 - f3) + f4));
        }
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)localList.get(49), (PointF)localList.get(63));
      localList.add(new PointF(localPointF2.x, localPointF2.y));
      j = localList.size();
      i = 50;
      while (i < 53)
      {
        localPointF2 = (PointF)localList.get(i);
        if (Math.abs(localPointF2.x - ((PointF)localObject).x) < 1.0D)
        {
          paramFloat = localPointF2.x;
          d2 = localPointF2.y;
          d3 = localPointF2.y - ((PointF)localObject).y;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localList.add(new PointF(paramFloat, (float)(d2 + d3 * 1.2D)));
        }
        else
        {
          paramFloat = (localPointF2.y - ((PointF)localObject).y) / (localPointF2.x - ((PointF)localObject).x);
          d2 = localPointF2.x;
          d3 = localPointF2.x - ((PointF)localObject).x;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f1 = (float)(d2 + d3 * 1.2D);
          localList.add(new PointF(f1, paramFloat * (f1 - ((PointF)localObject).x) + ((PointF)localObject).y));
        }
        i += 1;
      }
      localPointF3 = (PointF)localList.get(j);
      localObject = (PointF)localList.get(j + 1);
      localPointF2 = (PointF)localList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, (PointF)localObject);
      localObject = AlgoUtils.middlePoint(localPointF2, (PointF)localObject);
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      localList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
      paramList.reset();
      paramList.postTranslate(-localPointF1.x, -localPointF1.y);
      paramList.postRotate((float)Math.toDegrees(d1));
      paramList.postTranslate(localPointF1.x, localPointF1.y);
      return AlgoUtils.mapPoints(localList, paramList);
    }
    return new ArrayList();
  }
  
  public static void getFullCoords(Object paramObject1, int paramInt, float paramFloat, Object paramObject2)
  {
    nativeGetFullCoords(paramObject1, paramInt, paramFloat, paramObject2);
  }
  
  public static List<PointF> getFullCoords4BeautyFaceList(List<PointF> paramList, float paramFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      Object localObject2;
      if (paramList.size() > 90) {
        localObject2 = paramList.subList(0, 90);
      } else {
        localObject2 = paramList;
      }
      PointF localPointF1 = (PointF)((List)localObject2).get(0);
      Object localObject1 = (PointF)((List)localObject2).get(1);
      paramList = (PointF)((List)localObject2).get(9);
      PointF localPointF2 = (PointF)((List)localObject2).get(83);
      float f1 = localPointF2.x - paramList.x;
      float f4 = localPointF2.y - paramList.y;
      float f3 = (float)Math.sqrt(f1 * f1 + f4 * f4);
      float f2 = -f4 / f3;
      f3 = f1 / f3;
      f1 = (float)(Math.atan2(f1, f4) + 3.141592653589793D);
      paramList = new PointF();
      float f5 = AlgoUtils.getDistance(localPointF1, (PointF)localObject1);
      f4 = ((PointF)localObject1).x;
      f5 *= 2.0F;
      paramList.x = (f4 + f5 * f3);
      paramList.y = (((PointF)localObject1).y - f5 * f2);
      ((List)localObject2).add(paramList);
      Object localObject3 = new PointF();
      Object localObject4 = (PointF)((List)localObject2).get(17);
      localObject1 = (PointF)((List)localObject2).get(18);
      f5 = AlgoUtils.getDistance((PointF)localObject4, (PointF)localObject1);
      f4 = ((PointF)localObject4).x;
      f5 *= 2.0F;
      ((PointF)localObject3).x = (f4 + f5 * f3);
      ((PointF)localObject4).y -= f5 * f2;
      ((List)localObject2).add(localObject3);
      PointF localPointF3 = new PointF();
      localObject4 = (PointF)((List)localObject2).get(59);
      PointF localPointF4 = new PointF(localPointF2.x, localPointF2.y);
      f5 = AlgoUtils.getDistance((PointF)localObject4, localPointF4);
      f4 = ((PointF)localObject4).x;
      f5 = f5 * 1.2F * 2.0F;
      localPointF3.x = (f4 + f3 * f5);
      localPointF3.y = (((PointF)localObject4).y - f5 * f2);
      localObject4 = new android.graphics.Matrix();
      ((android.graphics.Matrix)localObject4).reset();
      ((android.graphics.Matrix)localObject4).postTranslate(-localPointF4.x, -localPointF4.y);
      ((android.graphics.Matrix)localObject4).postRotate((float)Math.toDegrees(-f1));
      ((android.graphics.Matrix)localObject4).postTranslate(localPointF4.x, localPointF4.y);
      int i = 2;
      double d2;
      double d3;
      double d1;
      double d4;
      while (i >= 1)
      {
        f2 = (float)Math.toRadians(i * 30.0F);
        localPointF4 = new PointF();
        f3 = AlgoUtils.getDistance(localPointF3, localPointF2);
        f4 = AlgoUtils.getDistance((PointF)localObject3, localPointF2);
        d2 = localPointF2.x;
        d3 = f4;
        d1 = f2;
        d4 = Math.cos(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        localPointF4.x = ((float)(d2 + d3 * d4));
        d2 = localPointF2.y;
        d3 = f3;
        d1 = Math.sin(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        localPointF4.y = ((float)(d2 - d3 * d1));
        localPointF4 = AlgoUtils.mapPoint(localPointF4, (android.graphics.Matrix)localObject4);
        ((List)localObject2).add(new PointF(localPointF4.x, localPointF4.y));
        i -= 1;
      }
      ((List)localObject2).add(localPointF3);
      i = 2;
      localObject3 = paramList;
      paramList = (List<PointF>)localObject1;
      localObject1 = localObject4;
      while (i >= 1)
      {
        f2 = (float)Math.toRadians(i * 30.0F);
        localObject4 = new PointF();
        f3 = AlgoUtils.getDistance(localPointF3, localPointF2);
        f4 = AlgoUtils.getDistance((PointF)localObject3, localPointF2);
        d2 = localPointF2.x;
        d3 = f4;
        d1 = f2;
        d4 = Math.cos(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        ((PointF)localObject4).x = ((float)(d2 - d3 * d4));
        d2 = localPointF2.y;
        d3 = f3;
        d1 = Math.sin(d1);
        Double.isNaN(d3);
        Double.isNaN(d2);
        ((PointF)localObject4).y = ((float)(d2 - d3 * d1));
        localObject4 = AlgoUtils.mapPoint((PointF)localObject4, (android.graphics.Matrix)localObject1);
        ((List)localObject2).add(new PointF(((PointF)localObject4).x, ((PointF)localObject4).y));
        i -= 1;
      }
      ((List)localObject2).add(new PointF(0.0F, 0.0F));
      ((List)localObject2).add(new PointF(0.0F, 0.0F));
      localObject1 = (PointF)((List)localObject2).get(64);
      localObject3 = (PointF)((List)localObject2).get(54);
      localObject4 = (PointF)((List)localObject2).get(44);
      localObject3 = new PointF(((PointF)localObject3).x - ((PointF)localObject4).x, ((PointF)localObject3).y - ((PointF)localObject4).y);
      localObject3 = new PointF(((PointF)localObject3).x * paramFloat, ((PointF)localObject3).y * paramFloat);
      localObject4 = new PointF(-((PointF)localObject3).y, ((PointF)localObject3).x);
      ((List)localObject2).add(new PointF(((PointF)localObject1).x - ((PointF)localObject3).x - ((PointF)localObject4).x, ((PointF)localObject1).y - ((PointF)localObject3).y - ((PointF)localObject4).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x - ((PointF)localObject3).x, ((PointF)localObject1).y - ((PointF)localObject3).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x - ((PointF)localObject3).x + ((PointF)localObject4).x, ((PointF)localObject1).y - ((PointF)localObject3).y + ((PointF)localObject4).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x + ((PointF)localObject4).x, ((PointF)localObject1).y + ((PointF)localObject4).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x + ((PointF)localObject3).x + ((PointF)localObject4).x, ((PointF)localObject1).y + ((PointF)localObject3).y + ((PointF)localObject4).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x + ((PointF)localObject3).x, ((PointF)localObject1).y + ((PointF)localObject3).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x + ((PointF)localObject3).x - ((PointF)localObject4).x, ((PointF)localObject1).y + ((PointF)localObject3).y - ((PointF)localObject4).y));
      ((List)localObject2).add(new PointF(((PointF)localObject1).x - ((PointF)localObject4).x, ((PointF)localObject1).y - ((PointF)localObject4).y));
      localObject4 = (PointF)((List)localObject2).get(3);
      localObject1 = (PointF)((List)localObject2).get(15);
      localPointF2 = (PointF)((List)localObject2).get(65);
      localObject3 = (PointF)((List)localObject2).get(66);
      localObject4 = AlgoUtils.middlePoint((PointF)localObject4, localPointF2);
      ((List)localObject2).add(new PointF(((PointF)localObject4).x, ((PointF)localObject4).y));
      localObject1 = AlgoUtils.middlePoint((PointF)localObject1, (PointF)localObject3);
      ((List)localObject2).add(new PointF(((PointF)localObject1).x, ((PointF)localObject1).y));
      localObject4 = (PointF)((List)localObject2).get(39);
      localObject1 = (PointF)((List)localObject2).get(49);
      localObject3 = (PointF)((List)localObject2).get(57);
      localPointF3 = (PointF)((List)localObject2).get(61);
      localPointF2 = (PointF)((List)localObject2).get(35);
      localObject3 = AlgoUtils.middlePoint(localPointF2, (PointF)localObject3);
      ((List)localObject2).add(new PointF(((PointF)localObject3).x, ((PointF)localObject3).y));
      localObject3 = (PointF)((List)localObject2).get(45);
      localPointF3 = AlgoUtils.middlePoint((PointF)localObject3, localPointF3);
      ((List)localObject2).add(new PointF(localPointF3.x, localPointF3.y));
      localPointF3 = (PointF)((List)localObject2).get(43);
      localPointF4 = (PointF)((List)localObject2).get(55);
      PointF localPointF5 = (PointF)((List)localObject2).get(41);
      PointF localPointF6 = (PointF)((List)localObject2).get(37);
      paramFloat = AlgoUtils.getDistance(localPointF2, (PointF)localObject4);
      AlgoUtils.getDistance(localPointF5, localPointF6);
      f2 = paramFloat / 50.0F;
      i = 35;
      while (i < 39)
      {
        localPointF2 = (PointF)((List)localObject2).get(i);
        j = i - 37;
        d1 = 2.0F - Math.abs(j);
        Double.isNaN(d1);
        paramFloat = (float)(Math.sin(d1 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 35)
        {
          f3 = (localPointF2.y - localPointF3.y) / (localPointF2.x - localPointF3.x);
          d1 = localPointF2.x;
          d2 = localPointF2.x - localPointF3.x;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramFloat = (float)(d1 + d2 * 0.9D);
          f3 = f3 * (paramFloat - localPointF3.x) + localPointF3.y;
        }
        else
        {
          f3 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF2.x;
          d1 = 10.0F * f2 * (paramFloat + 1.0F);
          d2 = f1 + f3;
          d4 = Math.sin(d2);
          Double.isNaN(d1);
          Double.isNaN(d3);
          paramFloat = (float)(d3 + d4 * d1);
          d3 = localPointF2.y;
          d2 = Math.cos(d2);
          Double.isNaN(d1);
          Double.isNaN(d3);
          f3 = (float)(d3 + d1 * d2);
        }
        f4 = paramFloat;
        if (i == 35)
        {
          f4 = paramFloat;
          if (paramFloat < localPointF1.x) {
            f4 = localPointF1.x;
          }
        }
        ((List)localObject2).add(new PointF(f4, f3));
        i += 1;
      }
      localObject4 = AlgoUtils.middlePoint((PointF)localObject4, localPointF4);
      ((List)localObject2).add(new PointF(((PointF)localObject4).x, ((PointF)localObject4).y));
      int j = ((List)localObject2).size();
      i = 40;
      int k;
      while (i < 43)
      {
        localObject4 = (PointF)((List)localObject2).get(i);
        k = i - 41;
        paramFloat = (float)Math.toRadians(k * 60.0F);
        d1 = 3.0F - Math.abs(k);
        Double.isNaN(d1);
        f3 = (float)(Math.sin(d1 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = ((PointF)localObject4).x;
        d1 = f2 * 16.0F * (f3 + 1.0F);
        d2 = f1 + paramFloat;
        d4 = Math.sin(d2);
        Double.isNaN(d1);
        Double.isNaN(d3);
        paramFloat = (float)(d3 - d4 * d1);
        d3 = ((PointF)localObject4).y;
        d2 = Math.cos(d2);
        Double.isNaN(d1);
        Double.isNaN(d3);
        ((List)localObject2).add(new PointF(paramFloat, (float)(d3 - d1 * d2)));
        i += 1;
      }
      localObject4 = (PointF)((List)localObject2).get(j);
      localPointF1 = (PointF)((List)localObject2).get(j + 1);
      localPointF2 = (PointF)((List)localObject2).get(j + 2);
      ((List)localObject2).add(AlgoUtils.middlePoint((PointF)localObject4, localPointF1));
      ((List)localObject2).add(AlgoUtils.middlePoint(localPointF2, localPointF1));
      localObject4 = (PointF)((List)localObject2).get(51);
      localObject4 = (PointF)((List)localObject2).get(47);
      localObject4 = (PointF)((List)localObject2).get(53);
      localPointF1 = (PointF)((List)localObject2).get(63);
      f4 = AlgoUtils.getDistance((PointF)localObject3, (PointF)localObject1) / 50.0F;
      i = 45;
      while (i < 49)
      {
        localObject3 = (PointF)((List)localObject2).get(i);
        j = i - 47;
        d1 = 2.0F - Math.abs(j);
        Double.isNaN(d1);
        paramFloat = (float)(Math.sin(d1 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f2 = (((PointF)localObject3).y - ((PointF)localObject4).y) / (((PointF)localObject3).x - ((PointF)localObject4).x);
          d1 = ((PointF)localObject3).x;
          d2 = ((PointF)localObject3).x - ((PointF)localObject4).x;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramFloat = (float)(d1 + d2 * 0.9D);
          f2 = f2 * (paramFloat - ((PointF)localObject4).x) + ((PointF)localObject4).y;
        }
        else
        {
          f2 = (float)Math.toRadians(j * 60.0F);
          d3 = ((PointF)localObject3).x;
          d1 = 10.0F * f4 * (paramFloat + 1.0F);
          d2 = f1 - f2;
          d4 = Math.sin(d2);
          Double.isNaN(d1);
          Double.isNaN(d3);
          paramFloat = (float)(d3 + d4 * d1);
          d3 = ((PointF)localObject3).y;
          d2 = Math.cos(d2);
          Double.isNaN(d1);
          Double.isNaN(d3);
          f2 = (float)(d3 + d1 * d2);
        }
        if (i == 45)
        {
          localObject3 = paramList;
          f3 = paramFloat;
          if (paramFloat > ((PointF)localObject3).x) {
            f3 = ((PointF)localObject3).x;
          }
        }
        else
        {
          f3 = paramFloat;
        }
        ((List)localObject2).add(new PointF(f3, f2));
        i += 1;
      }
      paramList = AlgoUtils.middlePoint((PointF)localObject1, localPointF1);
      ((List)localObject2).add(new PointF(paramList.x, paramList.y));
      j = ((List)localObject2).size();
      i = 50;
      while (i < 53)
      {
        paramList = (PointF)((List)localObject2).get(i);
        k = i - 51;
        paramFloat = (float)Math.toRadians(k * 60.0F);
        d1 = 3.0F - Math.abs(k);
        Double.isNaN(d1);
        f2 = (float)(Math.sin(d1 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = paramList.x;
        d1 = 16.0F * f4 * (f2 + 1.0F);
        d2 = f1 - paramFloat;
        d4 = Math.sin(d2);
        Double.isNaN(d1);
        Double.isNaN(d3);
        paramFloat = (float)(d3 - d4 * d1);
        d3 = paramList.y;
        d2 = Math.cos(d2);
        Double.isNaN(d1);
        Double.isNaN(d3);
        ((List)localObject2).add(new PointF(paramFloat, (float)(d3 - d1 * d2)));
        i += 1;
      }
      paramList = (PointF)((List)localObject2).get(j);
      localObject1 = (PointF)((List)localObject2).get(j + 1);
      localObject3 = (PointF)((List)localObject2).get(j + 2);
      ((List)localObject2).add(AlgoUtils.middlePoint(paramList, (PointF)localObject1));
      ((List)localObject2).add(AlgoUtils.middlePoint((PointF)localObject3, (PointF)localObject1));
      return localObject2;
    }
    return new ArrayList();
  }
  
  public static List<PointF> getFullCoordsForFaceOffFilter(List<PointF> paramList, float paramFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      PointF localPointF1 = new PointF((((PointF)paramList.get(41)).x + ((PointF)paramList.get(51)).x) / 2.0F, (((PointF)paramList.get(41)).y + ((PointF)paramList.get(51)).y) / 2.0F);
      float f1 = ((PointF)paramList.get(9)).x;
      float f2 = ((PointF)paramList.get(84)).x;
      float f3 = -((PointF)paramList.get(9)).y;
      float f4 = ((PointF)paramList.get(84)).y;
      double d1 = Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D;
      android.graphics.Matrix localMatrix = new android.graphics.Matrix();
      localMatrix.reset();
      localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
      localMatrix.postRotate((float)Math.toDegrees(-d1));
      localMatrix.postTranslate(localPointF1.x, localPointF1.y);
      paramList = AlgoUtils.mapPoints(paramList, localMatrix);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
      double d3 = ((PointF)paramList.get(1)).x;
      double d2 = f1 * 2.0F;
      double d4 = Math.sin(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(1)).y;
      d4 = Math.cos(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF2 = new PointF(f1, (float)(d3 - d2 * d4));
      paramList.add(localPointF2);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
      d3 = ((PointF)paramList.get(17)).x;
      d2 = f1 * 2.0F;
      d4 = Math.sin(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(17)).y;
      d4 = Math.cos(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF4 = new PointF(f1, (float)(d3 - d2 * d4));
      paramList.add(localPointF4);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
      d3 = ((PointF)paramList.get(59)).x;
      d2 = f1 * 2.0F;
      d4 = Math.sin(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      f1 = (float)(d3 + d4 * d2);
      d3 = ((PointF)paramList.get(59)).y;
      d4 = Math.cos(0.0D);
      Double.isNaN(d2);
      Double.isNaN(d3);
      PointF localPointF3 = new PointF(f1, (float)(d3 - d2 * d4));
      int i = 2;
      double d5;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF5 = new PointF();
        d3 = localPointF3.x;
        d4 = localPointF3.x - localPointF4.x;
        d5 = Math.cos(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF5.x = ((float)(d3 - d4 * d5));
        d3 = localPointF4.y;
        d4 = localPointF4.y - localPointF3.y;
        d2 = Math.sin(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF5.y = ((float)(d3 - d4 * d2));
        paramList.add(localPointF5);
        i -= 1;
      }
      i = 3;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF4 = new PointF();
        d3 = localPointF3.x;
        d4 = localPointF3.x - localPointF2.x;
        d5 = Math.cos(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF4.x = ((float)(d3 - d4 * d5));
        d3 = localPointF2.y;
        d4 = localPointF2.y - localPointF3.y;
        d2 = Math.sin(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localPointF4.y = ((float)(d3 - d4 * d2));
        paramList.add(localPointF4);
        i -= 1;
      }
      paramList.add(EMPTY_POINT);
      paramList.add(EMPTY_POINT);
      localPointF2 = (PointF)paramList.get(64);
      localPointF3 = (PointF)paramList.get(54);
      localPointF4 = (PointF)paramList.get(44);
      localPointF3 = new PointF(localPointF3.x - localPointF4.x, localPointF3.y - localPointF4.y);
      localPointF3 = new PointF(localPointF3.x * paramFloat, localPointF3.y * paramFloat);
      localPointF4 = new PointF(-localPointF3.y, localPointF3.x);
      paramList.add(new PointF(localPointF2.x - localPointF3.x - localPointF4.x, localPointF2.y - localPointF3.y - localPointF4.y));
      paramList.add(new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y));
      paramList.add(new PointF(localPointF2.x - localPointF3.x + localPointF4.x, localPointF2.y - localPointF3.y + localPointF4.y));
      paramList.add(new PointF(localPointF2.x + localPointF4.x, localPointF2.y + localPointF4.y));
      paramList.add(new PointF(localPointF2.x + localPointF3.x + localPointF4.x, localPointF2.y + localPointF3.y + localPointF4.y));
      paramList.add(new PointF(localPointF2.x + localPointF3.x, localPointF2.y + localPointF3.y));
      paramList.add(new PointF(localPointF2.x + localPointF3.x - localPointF4.x, localPointF2.y + localPointF3.y - localPointF4.y));
      paramList.add(new PointF(localPointF2.x - localPointF4.x, localPointF2.y - localPointF4.y));
      localPointF2 = (PointF)paramList.get(3);
      localPointF2 = (PointF)paramList.get(15);
      localPointF2 = (PointF)paramList.get(65);
      localPointF2 = (PointF)paramList.get(66);
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF2 = (PointF)paramList.get(2);
      localPointF2 = (PointF)paramList.get(16);
      localPointF2 = (PointF)paramList.get(39);
      localPointF3 = (PointF)paramList.get(57);
      localPointF3 = (PointF)paramList.get(61);
      localPointF3 = (PointF)paramList.get(35);
      localPointF4 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF4 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF4 = (PointF)paramList.get(43);
      PointF localPointF5 = (PointF)paramList.get(55);
      localPointF5 = (PointF)paramList.get(41);
      PointF localPointF6 = (PointF)paramList.get(37);
      paramFloat = AlgoUtils.getDistance(localPointF3, localPointF2);
      AlgoUtils.getDistance(localPointF5, localPointF6);
      f3 = paramFloat / 50.0F;
      i = 35;
      while (i < 39)
      {
        localPointF2 = (PointF)paramList.get(i);
        j = i - 37;
        d2 = 2.0F - Math.abs(j);
        Double.isNaN(d2);
        paramFloat = (float)(Math.sin(d2 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 35)
        {
          f1 = (localPointF2.y - localPointF4.y) / (localPointF2.x - localPointF4.x);
          paramFloat = localPointF2.x + (localPointF2.x - localPointF4.x) * 0.9F;
          f1 = f1 * (paramFloat - localPointF4.x) + localPointF4.y;
        }
        else
        {
          f1 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF2.x;
          d2 = 10.0F * f3 * (paramFloat + 1.0F);
          d4 = f1;
          Double.isNaN(d4);
          d4 = 0.0D + d4;
          d5 = Math.sin(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          paramFloat = (float)(d3 + d5 * d2);
          d3 = localPointF2.y;
          d4 = Math.cos(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f1 = (float)(d3 + d2 * d4);
        }
        if (i == 35)
        {
          f2 = paramFloat;
          if (paramFloat < ((PointF)paramList.get(0)).x) {
            f2 = ((PointF)paramList.get(0)).x;
          }
        }
        else
        {
          f2 = paramFloat;
        }
        paramList.add(new PointF(f2, f1));
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      int j = paramList.size();
      i = 40;
      int k;
      while (i < 43)
      {
        localPointF2 = (PointF)paramList.get(i);
        k = i - 41;
        paramFloat = (float)Math.toRadians(k * 60.0F);
        d2 = 3.0F - Math.abs(k);
        Double.isNaN(d2);
        f1 = (float)(Math.sin(d2 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = localPointF2.x;
        d2 = 16.0F * f3 * (f1 + 1.0F);
        d4 = paramFloat;
        Double.isNaN(d4);
        d4 += 0.0D;
        d5 = Math.sin(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramFloat = (float)(d3 - d5 * d2);
        d3 = localPointF2.y;
        d4 = Math.cos(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramList.add(new PointF(paramFloat, (float)(d3 - d2 * d4)));
        i += 1;
      }
      localPointF4 = (PointF)paramList.get(j);
      localPointF2 = (PointF)paramList.get(j + 1);
      localPointF3 = (PointF)paramList.get(j + 2);
      localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
      localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF3 = (PointF)paramList.get(51);
      localPointF4 = (PointF)paramList.get(47);
      localPointF2 = (PointF)paramList.get(54);
      localPointF5 = (PointF)paramList.get(63);
      paramFloat = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49));
      AlgoUtils.getDistance(localPointF3, localPointF4);
      f3 = paramFloat / 50.0F;
      i = 45;
      while (i < 49)
      {
        localPointF3 = (PointF)paramList.get(i);
        j = i - 47;
        d2 = 2.0F - Math.abs(j);
        Double.isNaN(d2);
        paramFloat = (float)(Math.sin(d2 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f1 = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
          paramFloat = localPointF3.x + (localPointF3.x - localPointF2.x) * 0.9F;
          f1 = f1 * (paramFloat - localPointF2.x) + localPointF2.y;
        }
        else
        {
          f1 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF3.x;
          d2 = 10.0F * f3 * (paramFloat + 1.0F);
          d4 = f1;
          Double.isNaN(d4);
          d4 = 0.0D - d4;
          d5 = Math.sin(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          paramFloat = (float)(d3 + d5 * d2);
          d3 = localPointF3.y;
          d4 = Math.cos(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f1 = (float)(d3 + d2 * d4);
        }
        if (i == 45)
        {
          f2 = paramFloat;
          if (paramFloat > ((PointF)paramList.get(18)).x) {
            f2 = ((PointF)paramList.get(18)).x;
          }
        }
        else
        {
          f2 = paramFloat;
        }
        paramList.add(new PointF(f2, f1));
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      j = paramList.size();
      i = 50;
      while (i < 53)
      {
        localPointF2 = (PointF)paramList.get(i);
        k = i - 51;
        paramFloat = (float)Math.toRadians(k * 60.0F);
        d2 = 3.0F - Math.abs(k);
        Double.isNaN(d2);
        f1 = (float)(Math.sin(d2 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = localPointF2.x;
        d2 = (f1 + 1.0F) * (16.0F * f3);
        d4 = paramFloat;
        Double.isNaN(d4);
        d4 = 0.0D - d4;
        d5 = Math.sin(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramFloat = (float)(d3 - d5 * d2);
        d3 = localPointF2.y;
        d4 = Math.cos(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramList.add(new PointF(paramFloat, (float)(d3 - d2 * d4)));
        i += 1;
      }
      localPointF4 = (PointF)paramList.get(j);
      localPointF2 = (PointF)paramList.get(j + 1);
      localPointF3 = (PointF)paramList.get(j + 2);
      localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
      localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localMatrix.reset();
      localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
      localMatrix.postRotate((float)Math.toDegrees(d1));
      localMatrix.postTranslate(localPointF1.x, localPointF1.y);
      return AlgoUtils.mapPoints(paramList, localMatrix);
    }
    return new ArrayList();
  }
  
  public static List<PointF> getFullCoordsForNoseAndOutline(List<PointF> paramList)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      if (paramList.size() > 97) {
        paramList.subList(97, paramList.size()).clear();
      }
      if ((paramList.size() != 90) && (paramList.size() != 97)) {
        return paramList;
      }
      PointF localPointF1 = new PointF((((PointF)paramList.get(41)).x + ((PointF)paramList.get(51)).x) / 2.0F, (((PointF)paramList.get(41)).y + ((PointF)paramList.get(51)).y) / 2.0F);
      float f1 = ((PointF)paramList.get(9)).x;
      float f2 = ((PointF)paramList.get(84)).x;
      float f3 = -((PointF)paramList.get(9)).y;
      float f4 = ((PointF)paramList.get(84)).y;
      double d1 = Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D;
      android.graphics.Matrix localMatrix = new android.graphics.Matrix();
      localMatrix.reset();
      localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
      localMatrix.postRotate((float)Math.toDegrees(-d1));
      localMatrix.postTranslate(localPointF1.x, localPointF1.y);
      paramList = AlgoUtils.mapPoints(paramList, localMatrix);
      double d3;
      double d2;
      double d4;
      double d5;
      if (paramList.size() == 90)
      {
        f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
        d3 = ((PointF)paramList.get(1)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)paramList.get(1)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF2 = new PointF(f1, (float)(d3 - d2 * d4));
        paramList.add(localPointF2);
        f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
        d3 = ((PointF)paramList.get(17)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)paramList.get(17)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF4 = new PointF(f1, (float)(d3 - d2 * d4));
        paramList.add(localPointF4);
        f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
        d3 = ((PointF)paramList.get(59)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)paramList.get(59)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF3 = new PointF(f1, (float)(d3 - d2 * d4));
        i = 2;
        while (i >= 1)
        {
          d2 = Math.toRadians(i * 30.0F);
          localPointF5 = new PointF();
          d3 = localPointF3.x;
          d4 = localPointF3.x - localPointF4.x;
          d5 = Math.cos(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF5.x = ((float)(d3 - d4 * d5));
          d3 = localPointF4.y;
          d4 = localPointF4.y - localPointF3.y;
          d2 = Math.sin(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF5.y = ((float)(d3 - d4 * d2));
          paramList.add(localPointF5);
          i -= 1;
        }
        i = 3;
        while (i >= 1)
        {
          d2 = Math.toRadians(i * 30.0F);
          localPointF4 = new PointF();
          d3 = localPointF3.x;
          d4 = localPointF3.x - localPointF2.x;
          d5 = Math.cos(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF4.x = ((float)(d3 - d4 * d5));
          d3 = localPointF2.y;
          d4 = localPointF2.y - localPointF3.y;
          d2 = Math.sin(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          localPointF4.y = ((float)(d3 - d4 * d2));
          paramList.add(localPointF4);
          i -= 1;
        }
      }
      paramList.add(EMPTY_POINT);
      paramList.add(EMPTY_POINT);
      PointF localPointF2 = (PointF)paramList.get(54);
      PointF localPointF3 = (PointF)paramList.get(44);
      localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
      localPointF2 = new PointF(localPointF2.x, localPointF2.y);
      localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
      f1 = AlgoUtils.getDistance(localPointF2, new PointF(0.0F, 0.0F));
      f2 = AlgoUtils.getDistance(localPointF3, new PointF(0.0F, 0.0F));
      localPointF2.x /= f1;
      localPointF2.y /= f1;
      localPointF3.x /= f2;
      localPointF3.y /= f2;
      PointF localPointF4 = (PointF)paramList.get(64);
      f1 = Math.abs(localPointF2.x * (((PointF)paramList.get(17)).x - ((PointF)paramList.get(56)).x) + localPointF2.y * (((PointF)paramList.get(17)).y - ((PointF)paramList.get(56)).y)) * 2.0F;
      f2 = Math.abs(localPointF2.x * (((PointF)paramList.get(1)).x - ((PointF)paramList.get(62)).x) + localPointF2.y * (((PointF)paramList.get(1)).y - ((PointF)paramList.get(62)).y)) * 2.0F;
      f3 = Math.abs(localPointF3.x * (((PointF)paramList.get(9)).x - localPointF4.x) + localPointF3.y * (((PointF)paramList.get(9)).y - localPointF4.y)) * 2.0F;
      f4 = Math.abs(localPointF3.x * (((PointF)paramList.get(87)).x - localPointF4.x) + localPointF3.y * (((PointF)paramList.get(87)).y - localPointF4.y)) * 2.0F;
      paramList.add(new PointF(localPointF4.x - localPointF2.x * f2 - localPointF3.x * f4, localPointF4.y - localPointF2.y * f2 - localPointF3.y * f4));
      paramList.add(new PointF(localPointF4.x - localPointF2.x * f2, localPointF4.y - localPointF2.y * f2));
      paramList.add(new PointF(localPointF4.x - localPointF2.x * f2 + localPointF3.x * f3, localPointF4.y - localPointF2.y * f2 + localPointF3.y * f3));
      paramList.add(new PointF(localPointF4.x + localPointF3.x * f3, localPointF4.y + localPointF3.y * f3));
      paramList.add(new PointF(localPointF4.x + localPointF2.x * f1 + localPointF3.x * f3, localPointF4.y + localPointF2.y * f1 + localPointF3.y * f3));
      paramList.add(new PointF(localPointF4.x + localPointF2.x * f1, localPointF4.y + localPointF2.y * f1));
      paramList.add(new PointF(localPointF4.x + localPointF2.x * f1 - localPointF3.x * f4, localPointF4.y + localPointF2.y * f1 - localPointF3.y * f4));
      paramList.add(new PointF(localPointF4.x - localPointF3.x * f4, localPointF4.y - localPointF3.y * f4));
      localPointF2 = (PointF)paramList.get(3);
      localPointF2 = (PointF)paramList.get(15);
      localPointF2 = (PointF)paramList.get(65);
      localPointF2 = (PointF)paramList.get(66);
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF2 = (PointF)paramList.get(2);
      localPointF2 = (PointF)paramList.get(16);
      localPointF2 = (PointF)paramList.get(39);
      localPointF3 = (PointF)paramList.get(57);
      localPointF3 = (PointF)paramList.get(61);
      localPointF3 = (PointF)paramList.get(35);
      localPointF4 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF4 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF4 = (PointF)paramList.get(43);
      PointF localPointF5 = (PointF)paramList.get(55);
      localPointF5 = (PointF)paramList.get(41);
      PointF localPointF6 = (PointF)paramList.get(37);
      f1 = AlgoUtils.getDistance(localPointF3, localPointF2);
      AlgoUtils.getDistance(localPointF5, localPointF6);
      f4 = f1 / 50.0F;
      int i = 35;
      while (i < 39)
      {
        localPointF2 = (PointF)paramList.get(i);
        j = i - 37;
        d2 = 2.0F - Math.abs(j);
        Double.isNaN(d2);
        f1 = (float)(Math.sin(d2 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 35)
        {
          f2 = (localPointF2.y - localPointF4.y) / (localPointF2.x - localPointF4.x);
          f1 = localPointF2.x + (localPointF2.x - localPointF4.x) * 0.9F;
          f2 = f2 * (f1 - localPointF4.x) + localPointF4.y;
        }
        else
        {
          f2 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF2.x;
          d2 = 10.0F * f4 * (f1 + 1.0F);
          d4 = f2;
          Double.isNaN(d4);
          d4 = 0.0D + d4;
          d5 = Math.sin(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f1 = (float)(d3 + d5 * d2);
          d3 = localPointF2.y;
          d4 = Math.cos(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f2 = (float)(d3 + d2 * d4);
        }
        f3 = f1;
        if (i == 35)
        {
          f3 = f1;
          if (f1 < ((PointF)paramList.get(0)).x) {
            f3 = ((PointF)paramList.get(0)).x;
          }
        }
        paramList.add(new PointF(f3, f2));
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      int j = paramList.size();
      i = 40;
      int k;
      while (i < 43)
      {
        localPointF2 = (PointF)paramList.get(i);
        k = i - 41;
        f1 = (float)Math.toRadians(k * 60.0F);
        d2 = 3.0F - Math.abs(k);
        Double.isNaN(d2);
        f2 = (float)(Math.sin(d2 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = localPointF2.x;
        d2 = (f2 + 1.0F) * (16.0F * f4);
        d4 = f1;
        Double.isNaN(d4);
        d4 = 0.0D + d4;
        d5 = Math.sin(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 - d5 * d2);
        d3 = localPointF2.y;
        d4 = Math.cos(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramList.add(new PointF(f1, (float)(d3 - d2 * d4)));
        i += 1;
      }
      localPointF4 = (PointF)paramList.get(j);
      localPointF2 = (PointF)paramList.get(j + 1);
      localPointF3 = (PointF)paramList.get(j + 2);
      localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
      localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF3 = (PointF)paramList.get(51);
      localPointF4 = (PointF)paramList.get(47);
      localPointF2 = (PointF)paramList.get(54);
      localPointF5 = (PointF)paramList.get(63);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49));
      AlgoUtils.getDistance(localPointF3, localPointF4);
      f4 = f1 / 50.0F;
      i = 45;
      while (i < 49)
      {
        localPointF3 = (PointF)paramList.get(i);
        j = i - 47;
        d2 = 2.0F - Math.abs(j);
        Double.isNaN(d2);
        f1 = (float)(Math.sin(d2 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f2 = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
          f1 = localPointF3.x + (localPointF3.x - localPointF2.x) * 0.9F;
          f2 = f2 * (f1 - localPointF2.x) + localPointF2.y;
        }
        else
        {
          f2 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF3.x;
          d2 = 10.0F * f4 * (f1 + 1.0F);
          d4 = f2;
          Double.isNaN(d4);
          d4 = 0.0D - d4;
          d5 = Math.sin(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f1 = (float)(d3 + d5 * d2);
          d3 = localPointF3.y;
          d4 = Math.cos(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f2 = (float)(d3 + d2 * d4);
        }
        f3 = f1;
        if (i == 45)
        {
          f3 = f1;
          if (f1 > ((PointF)paramList.get(18)).x) {
            f3 = ((PointF)paramList.get(18)).x;
          }
        }
        paramList.add(new PointF(f3, f2));
        i += 1;
      }
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      j = paramList.size();
      i = 50;
      while (i < 53)
      {
        localPointF2 = (PointF)paramList.get(i);
        k = i - 51;
        f1 = (float)Math.toRadians(k * 60.0F);
        d2 = 3.0F - Math.abs(k);
        Double.isNaN(d2);
        f2 = (float)(Math.sin(d2 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = localPointF2.x;
        d2 = (f2 + 1.0F) * (16.0F * f4);
        d4 = f1;
        Double.isNaN(d4);
        d4 = 0.0D - d4;
        d5 = Math.sin(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 - d5 * d2);
        d3 = localPointF2.y;
        d4 = Math.cos(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramList.add(new PointF(f1, (float)(d3 - d2 * d4)));
        i += 1;
      }
      localPointF4 = (PointF)paramList.get(j);
      localPointF2 = (PointF)paramList.get(j + 1);
      localPointF3 = (PointF)paramList.get(j + 2);
      localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
      localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localMatrix.reset();
      localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
      localMatrix.postRotate((float)Math.toDegrees(d1));
      localMatrix.postTranslate(localPointF1.x, localPointF1.y);
      return AlgoUtils.mapPoints(paramList, localMatrix);
    }
    return new ArrayList();
  }
  
  public static List<PointF> getFullCoords_v2(List<PointF> paramList, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramList.size() >= 90))
    {
      if (paramList.size() > 97) {
        paramList.subList(97, paramList.size()).clear();
      }
      if ((paramList.size() != 90) && (paramList.size() != 97)) {
        return paramList;
      }
      Object localObject1 = new PointF((((PointF)paramList.get(41)).x + ((PointF)paramList.get(51)).x) / 2.0F, (((PointF)paramList.get(41)).y + ((PointF)paramList.get(51)).y) / 2.0F);
      float f1 = ((PointF)paramList.get(9)).x;
      float f2 = ((PointF)paramList.get(84)).x;
      float f3 = -((PointF)paramList.get(9)).y;
      float f4 = ((PointF)paramList.get(84)).y;
      double d1 = Math.atan2(f1 - f2, f3 + f4) + 3.141592653589793D;
      android.graphics.Matrix localMatrix = new android.graphics.Matrix();
      localMatrix.reset();
      localMatrix.postTranslate(-((PointF)localObject1).x, -((PointF)localObject1).y);
      localMatrix.postRotate((float)Math.toDegrees(-d1));
      localMatrix.postTranslate(((PointF)localObject1).x, ((PointF)localObject1).y);
      List localList = AlgoUtils.mapPoints(paramList, localMatrix);
      double d3;
      double d2;
      double d4;
      double d5;
      if (localList.size() == 90)
      {
        f1 = AlgoUtils.getDistance((PointF)localList.get(0), (PointF)localList.get(1));
        d3 = ((PointF)localList.get(1)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)localList.get(1)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF1 = new PointF(f1, (float)(d3 - d2 * d4));
        localList.add(localPointF1);
        f1 = AlgoUtils.getDistance((PointF)localList.get(17), (PointF)localList.get(18));
        d3 = ((PointF)localList.get(17)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)localList.get(17)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localObject2 = new PointF(f1, (float)(d3 - d2 * d4));
        localList.add(localObject2);
        f1 = AlgoUtils.getDistance((PointF)localList.get(59), (PointF)localObject1);
        d3 = ((PointF)localList.get(59)).x;
        d2 = f1 * 2.0F;
        d4 = Math.sin(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        f1 = (float)(d3 + d4 * d2);
        d3 = ((PointF)localList.get(59)).y;
        d4 = Math.cos(0.0D);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localPointF2 = new PointF(f1, (float)(d3 - d2 * d4));
        i = 2;
        paramList = (List<PointF>)localObject1;
        while (i >= 1)
        {
          d2 = Math.toRadians(i * 30.0F);
          localObject1 = new PointF();
          d3 = localPointF2.x;
          d4 = localPointF2.x - ((PointF)localObject2).x;
          d5 = Math.cos(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          ((PointF)localObject1).x = ((float)(d3 - d4 * d5));
          d3 = ((PointF)localObject2).y;
          d4 = ((PointF)localObject2).y - localPointF2.y;
          d2 = Math.sin(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          ((PointF)localObject1).y = ((float)(d3 - d4 * d2));
          localList.add(localObject1);
          i -= 1;
        }
        i = 3;
        for (;;)
        {
          localObject2 = paramList;
          if (i < 1) {
            break;
          }
          d2 = Math.toRadians(i * 30.0F);
          localObject1 = new PointF();
          d3 = localPointF2.x;
          d4 = localPointF2.x - localPointF1.x;
          d5 = Math.cos(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          ((PointF)localObject1).x = ((float)(d3 - d4 * d5));
          d3 = localPointF1.y;
          d4 = localPointF1.y - localPointF2.y;
          d2 = Math.sin(d2);
          Double.isNaN(d4);
          Double.isNaN(d3);
          ((PointF)localObject1).y = ((float)(d3 - d4 * d2));
          localList.add(localObject1);
          i -= 1;
        }
      }
      Object localObject2 = localObject1;
      localList.add(EMPTY_POINT);
      localList.add(EMPTY_POINT);
      paramList = (PointF)localList.get(54);
      paramList = (PointF)localList.get(44);
      PointF localPointF1 = new PointF(((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x, ((PointF)localList.get(18)).y - ((PointF)localList.get(0)).y);
      paramList = new PointF(-localPointF1.y, localPointF1.x);
      if (paramList.y < 0.0F)
      {
        paramList.x = (-paramList.x);
        paramList.y = (-paramList.y);
      }
      f1 = AlgoUtils.getDistance(localPointF1, new PointF(0.0F, 0.0F));
      f2 = AlgoUtils.getDistance(paramList, new PointF(0.0F, 0.0F));
      localPointF1.x /= f1;
      localPointF1.y /= f1;
      paramList.x /= f2;
      paramList.y /= f2;
      localObject1 = (PointF)localList.get(56);
      PointF localPointF2 = (PointF)localList.get(62);
      PointF localPointF3 = (PointF)localList.get(17);
      PointF localPointF4 = (PointF)localList.get(1);
      PointF localPointF5 = (PointF)localList.get(9);
      PointF localPointF6 = (PointF)localList.get(87);
      PointF localPointF7 = (PointF)localList.get(64);
      f1 = Math.abs(localPointF1.x * (localPointF3.x - ((PointF)localObject1).x) + localPointF1.y * (localPointF3.y - ((PointF)localObject1).y));
      f2 = -Math.abs(localPointF1.x * (localPointF4.x - localPointF2.x) + localPointF1.y * (localPointF4.y - localPointF2.y));
      f3 = Math.abs(paramList.x * (localPointF5.x - localPointF7.x) + paramList.y * (localPointF5.y - localPointF7.y));
      f4 = -Math.abs(paramList.x * (localPointF6.x - localPointF7.x) + paramList.y * (localPointF6.y - localPointF7.y));
      localList.add(new PointF(localPointF7.x + localPointF1.x * f2 * paramFloat1 + paramList.x * f4 * paramFloat1, localPointF7.y + localPointF1.y * f2 * paramFloat1 + paramList.y * f4 * paramFloat1));
      localList.add(new PointF(localPointF7.x + localPointF1.x * f2 * paramFloat1, localPointF7.y + localPointF1.y * f2 * paramFloat1));
      localList.add(new PointF(localPointF7.x + localPointF1.x * f2 * paramFloat1 + paramList.x * f3 * paramFloat1, localPointF7.y + localPointF1.y * f2 * paramFloat1 + paramList.y * f3 * paramFloat1));
      localList.add(new PointF(localPointF7.x + paramList.x * f3 * paramFloat1, localPointF7.y + paramList.y * f3 * paramFloat1));
      localList.add(new PointF(localPointF7.x + localPointF1.x * f1 * paramFloat1 + paramList.x * f3 * paramFloat1, localPointF7.y + localPointF1.y * f1 * paramFloat1 + paramList.y * f3 * paramFloat1));
      localList.add(new PointF(localPointF7.x + localPointF1.x * f1 * paramFloat1, localPointF7.y + localPointF1.y * f1 * paramFloat1));
      localList.add(new PointF(localPointF7.x + localPointF1.x * f1 * paramFloat1 + paramList.x * f4 * paramFloat1, localPointF7.y + localPointF1.y * f1 * paramFloat1 + paramList.y * f4 * paramFloat1));
      localList.add(new PointF(localPointF7.x + paramList.x * f4 * paramFloat1, localPointF7.y + paramList.y * f4 * paramFloat1));
      paramList = (PointF)localList.get(3);
      paramList = (PointF)localList.get(15);
      paramList = (PointF)localList.get(65);
      localPointF2 = (PointF)localList.get(66);
      if (paramFloat2 < 0.0F)
      {
        localObject1 = new PointF(paramList.x + localPointF1.x * f2 * 10.0F, paramList.y + localPointF1.y * f2 * 10.0F);
        i = 1;
        while (i < 9)
        {
          localPointF3 = (PointF)localList.get(i);
          i += 1;
          localPointF3 = AlgoUtils.getCrossPoint(paramList, (PointF)localObject1, localPointF3, (PointF)localList.get(i));
          if (localPointF3 != null)
          {
            if (paramBoolean) {
              paramFloat1 = 0.0F;
            } else {
              paramFloat1 = Math.min(1.8F - (float)(Math.cos(paramFloat2) * 1.8D), 0.5F);
            }
            localObject1 = AlgoUtils.getBetweenPoint(localPointF3, (PointF)localList.get(65), paramFloat1);
            paramList = AlgoUtils.getBetweenPoint(localPointF3, (PointF)localList.get(65), Math.min(paramFloat1, 0.4F));
            localList.add(new PointF(((PointF)localObject1).x, ((PointF)localObject1).y));
            i = 1;
            break label2284;
          }
        }
        i = 0;
        paramList = null;
        label2284:
        if (i == 0)
        {
          paramList = (PointF)localList.get(1);
          if (paramBoolean) {
            paramFloat1 = 0.0F;
          } else {
            paramFloat1 = Math.min(1.8F - (float)(Math.cos(paramFloat2) * 1.8D), 0.5F);
          }
          localObject1 = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), paramFloat1);
          paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), Math.min(paramFloat1, 0.4F));
          localList.add(new PointF(((PointF)localObject1).x, ((PointF)localObject1).y));
        }
        localObject1 = paramList;
      }
      else
      {
        localObject1 = new PointF(paramList.x + localPointF1.x * f2 * 10.0F, paramList.y + localPointF1.y * f2 * 10.0F);
        i = 1;
        while (i < 9)
        {
          localPointF3 = (PointF)localList.get(i);
          i += 1;
          localPointF3 = AlgoUtils.getCrossPoint(paramList, (PointF)localObject1, localPointF3, (PointF)localList.get(i));
          if (localPointF3 != null)
          {
            paramFloat1 = (float)(Math.cos(paramFloat2) * 4.0D - 4.0D);
            paramList = AlgoUtils.getBetweenPoint(localPointF3, (PointF)localList.get(65), paramFloat1);
            localList.add(new PointF(paramList.x, paramList.y));
            i = 1;
            break label2571;
          }
        }
        i = 0;
        label2571:
        if (i == 0)
        {
          paramList = (PointF)localList.get(1);
          paramFloat1 = (float)(Math.cos(paramFloat2) * 4.0D - 4.0D);
          paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), paramFloat1);
          localList.add(new PointF(paramList.x, paramList.y));
        }
        localObject1 = null;
      }
      int i = 9;
      int k = 1;
      int j = 1;
      if (paramFloat2 < 0.0F)
      {
        paramList = new PointF(localPointF2.x + localPointF1.x * f1 * 10.0F, localPointF2.y + localPointF1.y * f1 * 10.0F);
        while (i < 17)
        {
          localPointF1 = (PointF)localList.get(i);
          i += 1;
          localPointF1 = AlgoUtils.getCrossPoint(localPointF2, paramList, localPointF1, (PointF)localList.get(i));
          if (localPointF1 != null)
          {
            paramFloat1 = (float)(Math.cos(paramFloat2) * 4.0D - 4.0D);
            paramList = AlgoUtils.getBetweenPoint(localPointF1, (PointF)localList.get(66), paramFloat1);
            localList.add(new PointF(paramList.x, paramList.y));
            i = j;
            break label2831;
          }
        }
        i = 0;
        label2831:
        if (i == 0)
        {
          paramList = (PointF)localList.get(17);
          paramFloat1 = (float)(Math.cos(paramFloat2) * 4.0D - 4.0D);
          paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), paramFloat1);
          localList.add(new PointF(paramList.x, paramList.y));
        }
        paramList = null;
      }
      else
      {
        paramList = new PointF(localPointF2.x + localPointF1.x * f1 * 10.0F, localPointF2.y + localPointF1.y * f1 * 10.0F);
        while (i < 17)
        {
          localPointF1 = (PointF)localList.get(i);
          i += 1;
          localPointF1 = AlgoUtils.getCrossPoint(localPointF2, paramList, localPointF1, (PointF)localList.get(i));
          if (localPointF1 != null)
          {
            if (paramBoolean) {
              paramFloat1 = 0.0F;
            } else {
              paramFloat1 = Math.min(1.8F - (float)(Math.cos(paramFloat2) * 1.8D), 0.5F);
            }
            localPointF2 = AlgoUtils.getBetweenPoint(localPointF1, (PointF)localList.get(66), paramFloat1);
            paramList = AlgoUtils.getBetweenPoint(localPointF1, (PointF)localList.get(66), Math.min(paramFloat1, 0.4F));
            localList.add(new PointF(localPointF2.x, localPointF2.y));
            i = k;
            break label3120;
          }
        }
        i = 0;
        paramList = null;
        label3120:
        if (i == 0)
        {
          paramList = (PointF)localList.get(17);
          if (paramBoolean) {
            paramFloat1 = 0.0F;
          } else {
            paramFloat1 = Math.min(1.8F - (float)(Math.cos(paramFloat2) * 1.8D), 0.5F);
          }
          localPointF1 = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), paramFloat1);
          paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), Math.min(paramFloat1, 0.4F));
          localList.add(new PointF(localPointF1.x, localPointF1.y));
        }
      }
      localPointF1 = (PointF)localList.get(2);
      localPointF1 = (PointF)localList.get(16);
      localPointF4 = (PointF)localList.get(39);
      localPointF1 = (PointF)localList.get(57);
      localPointF1 = (PointF)localList.get(61);
      localPointF5 = (PointF)localList.get(35);
      if (paramFloat2 < 0.0F)
      {
        if (paramBoolean) {
          paramFloat1 = 0.0F;
        } else {
          paramFloat1 = Math.min(1.2F - (float)(Math.cos(paramFloat2) * 1.2D), 0.5F);
        }
        localPointF1 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), paramFloat1);
        localPointF2 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), 0.1F);
        localList.add(new PointF(localPointF1.x, localPointF2.y));
        localPointF1 = new PointF(AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), Math.min(paramFloat1, 0.3F)).x, localPointF2.y);
      }
      else
      {
        paramFloat1 = (float)(Math.cos(paramFloat2) * 3.0D - 3.0D);
        localPointF1 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), paramFloat1);
        localPointF2 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), 0.1F);
        if ((((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x) * (((PointF)localList.get(56)).x - ((PointF)localList.get(0)).x) <= 0.0F) {
          localList.add(new PointF(((PointF)localList.get(0)).x, ((PointF)localList.get(0)).y));
        } else {
          localList.add(new PointF(localPointF1.x, localPointF2.y));
        }
        localPointF1 = null;
      }
      if (paramFloat2 < 0.0F)
      {
        paramFloat1 = (float)(Math.cos(paramFloat2) * 3.0D - 3.0D);
        localPointF2 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), paramFloat1);
        localPointF3 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), 0.1F);
        if ((((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x) * (((PointF)localList.get(18)).x - ((PointF)localList.get(62)).x) <= 0.0F) {
          localList.add(new PointF(((PointF)localList.get(18)).x, ((PointF)localList.get(18)).y));
        } else {
          localList.add(new PointF(localPointF2.x, localPointF3.y));
        }
        localPointF2 = null;
      }
      else
      {
        if (paramBoolean) {
          paramFloat1 = 0.0F;
        } else {
          paramFloat1 = Math.min(1.2F - (float)(Math.cos(paramFloat2) * 1.2D), 0.5F);
        }
        localPointF2 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), paramFloat1);
        localPointF3 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), 0.1F);
        localList.add(new PointF(localPointF2.x, localPointF3.y));
        localPointF2 = new PointF(AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), Math.min(paramFloat1, 0.3F)).x, localPointF3.y);
      }
      localPointF3 = (PointF)localList.get(43);
      localPointF6 = (PointF)localList.get(55);
      localPointF6 = (PointF)localList.get(41);
      localPointF7 = (PointF)localList.get(37);
      paramFloat1 = AlgoUtils.getDistance(localPointF5, localPointF4);
      AlgoUtils.getDistance(localPointF6, localPointF7);
      f3 = paramFloat1 / 50.0F;
      i = 35;
      while (i < 39)
      {
        localPointF4 = (PointF)localList.get(i);
        j = i - 37;
        d2 = 2.0F - Math.abs(j);
        Double.isNaN(d2);
        paramFloat1 = (float)(Math.sin(d2 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 35)
        {
          f1 = (localPointF4.y - localPointF3.y) / (localPointF4.x - localPointF3.x);
          paramFloat1 = localPointF4.x + (localPointF4.x - localPointF3.x) * 0.9F;
          f1 = f1 * (paramFloat1 - localPointF3.x) + localPointF3.y;
        }
        else
        {
          f1 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF4.x;
          d2 = f3 * 10.0F * (paramFloat1 + 1.0F);
          d4 = f1;
          Double.isNaN(d4);
          d4 = 0.0D + d4;
          d5 = Math.sin(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          paramFloat1 = (float)(d3 + d5 * d2);
          d3 = localPointF4.y;
          d4 = Math.cos(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f1 = (float)(d3 + d2 * d4);
        }
        if (i == 35)
        {
          f2 = paramFloat1;
          if (paramFloat1 < ((PointF)localList.get(0)).x) {
            f2 = ((PointF)localList.get(0)).x;
          }
        }
        else
        {
          f2 = paramFloat1;
        }
        localList.add(new PointF(f2, f1));
        i += 1;
      }
      localPointF3 = AlgoUtils.middlePoint((PointF)localList.get(39), (PointF)localList.get(55));
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      j = localList.size();
      i = 40;
      while (i < 43)
      {
        localPointF3 = (PointF)localList.get(i);
        k = i - 41;
        paramFloat1 = (float)Math.toRadians(k * 60.0F);
        d2 = 3.0F - Math.abs(k);
        Double.isNaN(d2);
        f1 = (float)(Math.sin(d2 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = localPointF3.x;
        d2 = 16.0F * f3 * (f1 + 1.0F);
        d4 = paramFloat1;
        Double.isNaN(d4);
        d4 = 0.0D + d4;
        d5 = Math.sin(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramFloat1 = (float)(d3 - d5 * d2);
        d3 = localPointF3.y;
        d4 = Math.cos(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localList.add(new PointF(paramFloat1, (float)(d3 - d2 * d4)));
        i += 1;
      }
      localPointF5 = (PointF)localList.get(j);
      localPointF3 = (PointF)localList.get(j + 1);
      localPointF4 = (PointF)localList.get(j + 2);
      localPointF5 = AlgoUtils.middlePoint(localPointF5, localPointF3);
      localPointF3 = AlgoUtils.middlePoint(localPointF4, localPointF3);
      localList.add(new PointF(localPointF5.x, localPointF5.y));
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      localPointF4 = (PointF)localList.get(51);
      localPointF5 = (PointF)localList.get(47);
      localPointF3 = (PointF)localList.get(54);
      localPointF6 = (PointF)localList.get(63);
      paramFloat1 = AlgoUtils.getDistance((PointF)localList.get(45), (PointF)localList.get(49));
      AlgoUtils.getDistance(localPointF4, localPointF5);
      f3 = paramFloat1 / 50.0F;
      i = 45;
      while (i < 49)
      {
        localPointF4 = (PointF)localList.get(i);
        j = i - 47;
        d2 = 2.0F - Math.abs(j);
        Double.isNaN(d2);
        paramFloat1 = (float)(Math.sin(d2 * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f1 = (localPointF4.y - localPointF3.y) / (localPointF4.x - localPointF3.x);
          paramFloat1 = localPointF4.x + (localPointF4.x - localPointF3.x) * 0.9F;
          f1 = f1 * (paramFloat1 - localPointF3.x) + localPointF3.y;
        }
        else
        {
          f1 = (float)Math.toRadians(j * 60.0F);
          d3 = localPointF4.x;
          d2 = f3 * 10.0F * (paramFloat1 + 1.0F);
          d4 = f1;
          Double.isNaN(d4);
          d4 = 0.0D - d4;
          d5 = Math.sin(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          paramFloat1 = (float)(d3 + d5 * d2);
          d3 = localPointF4.y;
          d4 = Math.cos(d4);
          Double.isNaN(d2);
          Double.isNaN(d3);
          f1 = (float)(d3 + d2 * d4);
        }
        if (i == 45)
        {
          f2 = paramFloat1;
          if (paramFloat1 > ((PointF)localList.get(18)).x) {
            f2 = ((PointF)localList.get(18)).x;
          }
        }
        else
        {
          f2 = paramFloat1;
        }
        localList.add(new PointF(f2, f1));
        i += 1;
      }
      localPointF3 = AlgoUtils.middlePoint((PointF)localList.get(49), (PointF)localList.get(63));
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      j = localList.size();
      i = 50;
      while (i < 53)
      {
        localPointF3 = (PointF)localList.get(i);
        k = i - 51;
        paramFloat1 = (float)Math.toRadians(k * 60.0F);
        d2 = 3.0F - Math.abs(k);
        Double.isNaN(d2);
        f1 = (float)(Math.sin(d2 * 3.141592653589793D / 2.0D) * 0.3D);
        d3 = localPointF3.x;
        d2 = 16.0F * f3 * (f1 + 1.0F);
        d4 = paramFloat1;
        Double.isNaN(d4);
        d4 = 0.0D - d4;
        d5 = Math.sin(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        paramFloat1 = (float)(d3 - d5 * d2);
        d3 = localPointF3.y;
        d4 = Math.cos(d4);
        Double.isNaN(d2);
        Double.isNaN(d3);
        localList.add(new PointF(paramFloat1, (float)(d3 - d2 * d4)));
        i += 1;
      }
      localPointF5 = (PointF)localList.get(j);
      localPointF3 = (PointF)localList.get(j + 1);
      localPointF4 = (PointF)localList.get(j + 2);
      localPointF5 = AlgoUtils.middlePoint(localPointF5, localPointF3);
      localPointF3 = AlgoUtils.middlePoint(localPointF4, localPointF3);
      localList.add(new PointF(localPointF5.x, localPointF5.y));
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      localPointF3 = (PointF)localList.get(109);
      localPointF4 = (PointF)localList.get(110);
      localPointF3 = AlgoUtils.getBetweenPoint(localPointF3, AlgoUtils.middlePoint((PointF)localList.get(56), (PointF)localList.get(62)), 0.5F);
      localPointF4 = AlgoUtils.getBetweenPoint(localPointF4, AlgoUtils.middlePoint((PointF)localList.get(56), (PointF)localList.get(62)), 0.5F);
      localPointF5 = new PointF(localPointF3.x, localPointF3.y);
      localPointF6 = new PointF(localPointF4.x, localPointF4.y);
      if (paramFloat2 < 0.0F) {
        localPointF4 = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint((PointF)localList.get(45), (PointF)localList.get(61)), localPointF4, Math.max((float)Math.cos(paramFloat2) * 15.0F - 14.0F, 0.0F));
      } else {
        localPointF3 = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint((PointF)localList.get(35), (PointF)localList.get(57)), localPointF3, Math.max((float)Math.cos(-paramFloat2) * 15.0F - 14.0F, 0.0F));
      }
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      localList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF7 = (PointF)localList.get(107);
      PointF localPointF8 = (PointF)localList.get(108);
      localPointF3 = AlgoUtils.getBetweenPoint(localPointF7, (PointF)localList.get(65), 0.5F);
      localPointF4 = AlgoUtils.getBetweenPoint(localPointF8, (PointF)localList.get(66), 0.5F);
      if (paramFloat2 < 0.0F)
      {
        localPointF5 = AlgoUtils.middlePoint((PointF)localList.get(14), (PointF)localList.get(66));
        d2 = paramFloat2;
        localPointF4 = AlgoUtils.getBetweenPoint(localPointF5, localPointF4, Math.max((float)Math.cos(d2) * 12.0F - 11.0F, 0.0F));
        localPointF5 = new PointF(((PointF)localList.get(110)).x - localPointF6.x, ((PointF)localList.get(110)).y - localPointF6.y);
        localList.set(108, AlgoUtils.getBetweenPoint(new PointF(localPointF4.x + localPointF5.x * 0.8F, localPointF4.y + localPointF5.y * 0.8F), localPointF8, Math.max((float)Math.cos(d2) * 8.0F - 7.0F, 0.0F)));
      }
      else
      {
        localPointF6 = AlgoUtils.middlePoint((PointF)localList.get(4), (PointF)localList.get(65));
        d2 = -paramFloat2;
        localPointF3 = AlgoUtils.getBetweenPoint(localPointF6, localPointF3, Math.max((float)Math.cos(d2) * 12.0F - 11.0F, 0.0F));
        localPointF5 = new PointF(((PointF)localList.get(109)).x - localPointF5.x, ((PointF)localList.get(109)).y - localPointF5.y);
        localList.set(107, AlgoUtils.getBetweenPoint(new PointF(localPointF3.x + localPointF5.x * 0.8F, localPointF3.y + localPointF5.y * 0.8F), localPointF7, Math.max((float)Math.cos(d2) * 8.0F - 7.0F, 0.0F)));
      }
      localList.add(new PointF(localPointF3.x, localPointF3.y));
      localList.add(new PointF(localPointF4.x, localPointF4.y));
      if (localObject1 != null) {
        localList.set(107, localObject1);
      }
      if (paramList != null) {
        localList.set(108, paramList);
      }
      if (localPointF1 != null) {
        localList.set(109, localPointF1);
      }
      if (localPointF2 != null) {
        localList.set(110, localPointF2);
      }
      if (paramBoolean)
      {
        localList.set(107, AlgoUtils.middlePoint((PointF)localList.get(3), (PointF)localList.get(65)));
        localList.set(108, AlgoUtils.middlePoint((PointF)localList.get(15), (PointF)localList.get(66)));
        localList.set(109, AlgoUtils.middlePoint((PointF)localList.get(35), (PointF)localList.get(57)));
        localList.set(110, AlgoUtils.middlePoint((PointF)localList.get(45), (PointF)localList.get(61)));
        localList.set(131, AlgoUtils.middlePoint((PointF)localList.get(35), (PointF)localList.get(57)));
        localList.set(132, AlgoUtils.middlePoint((PointF)localList.get(45), (PointF)localList.get(61)));
        localList.set(133, AlgoUtils.middlePoint((PointF)localList.get(3), (PointF)localList.get(65)));
        localList.set(134, AlgoUtils.middlePoint((PointF)localList.get(15), (PointF)localList.get(66)));
      }
      localMatrix.reset();
      localMatrix.postTranslate(-((PointF)localObject2).x, -((PointF)localObject2).y);
      localMatrix.postRotate((float)Math.toDegrees(d1));
      localMatrix.postTranslate(((PointF)localObject2).x, ((PointF)localObject2).y);
      return AlgoUtils.mapPoints(localList, localMatrix);
    }
    return new ArrayList();
  }
  
  public static float[] getFullOpacityForFaceOffFilter_v2(List<PointF> paramList, float paramFloat)
  {
    float[] arrayOfFloat = new float[''];
    Arrays.fill(arrayOfFloat, 1.0F);
    double d;
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramFloat < 0.0F)
    {
      d = paramFloat;
      if (d < -0.610865238198015D)
      {
        Double.isNaN(d);
        f1 = (float)(d * 180.0D / 3.141592653589793D);
        f2 = arrayOfFloat[27];
        f3 = (35.0F + f1) * 0.2F + 1.0F;
        arrayOfFloat[27] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[45] *= Math.max(0.0F, Math.min(1.0F, f3));
        f2 = arrayOfFloat[28];
        f3 = (40.0F + f1) * 0.2F + 1.0F;
        arrayOfFloat[28] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[34] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[46] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[52] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[18] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[17] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[16] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[15] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[14] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[13] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[12] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[11] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[10] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[88] *= Math.max(0.0F, Math.min(1.0F, f3));
        f3 = arrayOfFloat[29];
        f2 = 45.0F + f1;
        f4 = f2 * 0.1F + 1.0F;
        arrayOfFloat[29] = (f3 * Math.max(0.0F, Math.min(1.0F, f4)));
        arrayOfFloat[33] *= Math.max(0.0F, Math.min(1.0F, f4));
        arrayOfFloat[47] *= Math.max(0.0F, Math.min(1.0F, f4));
        arrayOfFloat[51] *= Math.max(0.0F, Math.min(1.0F, f4));
        f3 = arrayOfFloat[30];
        f4 = (50.0F + f1) * 0.2F + 1.0F;
        arrayOfFloat[30] = (f3 * Math.max(0.0F, Math.min(1.0F, f4)));
        arrayOfFloat[31] *= Math.max(0.0F, Math.min(1.0F, f4));
        arrayOfFloat[32] *= Math.max(0.0F, Math.min(1.0F, f4));
        arrayOfFloat[48] *= Math.max(0.0F, Math.min(1.0F, f4));
        arrayOfFloat[49] *= Math.max(0.0F, Math.min(1.0F, f4));
        arrayOfFloat[50] *= Math.max(0.0F, Math.min(1.0F, f4));
        f4 = arrayOfFloat[60];
        f3 = 0.2F * f2 + 1.0F;
        arrayOfFloat[60] = (f4 * Math.max(0.0F, Math.min(1.0F, f3)));
        float f5 = arrayOfFloat[61];
        f4 = 0.5F * f2 + 1.0F;
        arrayOfFloat[61] = (f5 * Math.max(0.0F, Math.min(1.0F, f4)));
        f5 = arrayOfFloat[62];
        f1 = (f1 + 55.0F) * 0.1F + 1.0F;
        arrayOfFloat[62] = (f5 * Math.max(0.0F, Math.min(1.0F, f1)));
        arrayOfFloat[63] *= Math.max(0.0F, Math.min(1.0F, f1));
        arrayOfFloat[66] *= Math.max(0.0F, Math.min(1.0F, f4));
        f1 = arrayOfFloat[71];
        f2 = f2 * 0.3F + 1.0F;
        arrayOfFloat[71] = (f1 * Math.max(0.0F, Math.min(1.0F, f2)));
        arrayOfFloat[70] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[78] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[79] *= Math.max(0.0F, Math.min(1.0F, f2));
        arrayOfFloat[72] *= Math.max(0.0F, Math.min(1.0F, f2));
        arrayOfFloat[80] *= Math.max(0.0F, Math.min(1.0F, f2));
      }
    }
    else
    {
      d = paramFloat;
      if (d > 0.610865238198015D)
      {
        Double.isNaN(d);
        f1 = (float)(d * 180.0D / 3.141592653589793D);
        f2 = arrayOfFloat[19];
        f3 = 1.0F - (f1 - 35.0F) * 0.2F;
        arrayOfFloat[19] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[35] *= Math.max(0.0F, Math.min(1.0F, f3));
        f2 = arrayOfFloat[20];
        f3 = 1.0F - (f1 - 40.0F) * 0.2F;
        arrayOfFloat[20] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[26] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[36] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[42] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[0] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[1] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[2] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[3] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[4] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[5] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[6] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[7] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[8] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[86] *= Math.max(0.0F, Math.min(1.0F, f3));
        f2 = arrayOfFloat[21];
        f3 = 1.0F - (f1 - 45.0F) * 0.1F;
        arrayOfFloat[21] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[25] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[37] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[41] *= Math.max(0.0F, Math.min(1.0F, f3));
        f2 = arrayOfFloat[22];
        f3 = 1.0F - (f1 - 50.0F) * 0.2F;
        arrayOfFloat[22] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[23] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[24] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[38] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[39] *= Math.max(0.0F, Math.min(1.0F, f3));
        arrayOfFloat[40] *= Math.max(0.0F, Math.min(1.0F, f3));
        f2 = arrayOfFloat[55];
        f3 = 1.0F - (f1 - 55.0F) * 0.1F;
        arrayOfFloat[55] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        arrayOfFloat[56] *= Math.max(0.0F, Math.min(1.0F, f3));
        f2 = arrayOfFloat[57];
        f1 -= 42.0F;
        f3 = 1.0F - 0.5F * f1;
        arrayOfFloat[57] = (f2 * Math.max(0.0F, Math.min(1.0F, f3)));
        f4 = arrayOfFloat[58];
        f2 = 1.0F - 0.2F * f1;
        arrayOfFloat[58] = (f4 * Math.max(0.0F, Math.min(1.0F, f2)));
        arrayOfFloat[65] *= Math.max(0.0F, Math.min(1.0F, f3));
        f3 = arrayOfFloat[67];
        f1 = 1.0F - f1 * 0.3F;
        arrayOfFloat[67] = (f3 * Math.max(0.0F, Math.min(1.0F, f1)));
        arrayOfFloat[68] *= Math.max(0.0F, Math.min(1.0F, f2));
        arrayOfFloat[75] *= Math.max(0.0F, Math.min(1.0F, f1));
        arrayOfFloat[76] *= Math.max(0.0F, Math.min(1.0F, f2));
        arrayOfFloat[74] *= Math.max(0.0F, Math.min(1.0F, f1));
        arrayOfFloat[82] *= Math.max(0.0F, Math.min(1.0F, f1));
      }
    }
    return calcFullProbability_v2(paramList, arrayOfFloat, paramFloat);
  }
  
  public static float[] getFullPointsOpacityForFaceOffFilter(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[''];
    int i = 0;
    while (i < 90)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i];
      i += 1;
    }
    arrayOfFloat[90] = arrayOfFloat[1];
    arrayOfFloat[91] = arrayOfFloat[17];
    arrayOfFloat[92] = 1.0F;
    arrayOfFloat[93] = 1.0F;
    arrayOfFloat[94] = 1.0F;
    arrayOfFloat[95] = 1.0F;
    arrayOfFloat[96] = 1.0F;
    arrayOfFloat[97] = 0.0F;
    arrayOfFloat[98] = 0.0F;
    arrayOfFloat[99] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[100] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[101] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[102] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[103] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[104] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[105] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[106] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[107] = arrayOfFloat[36];
    arrayOfFloat[108] = arrayOfFloat[46];
    arrayOfFloat[109] = arrayOfFloat[36];
    arrayOfFloat[110] = arrayOfFloat[46];
    arrayOfFloat[111] = arrayOfFloat[35];
    arrayOfFloat[112] = arrayOfFloat[36];
    arrayOfFloat[113] = arrayOfFloat[37];
    arrayOfFloat[114] = arrayOfFloat[38];
    arrayOfFloat[115] = arrayOfFloat[39];
    arrayOfFloat[116] = arrayOfFloat[40];
    arrayOfFloat[117] = arrayOfFloat[41];
    arrayOfFloat[118] = arrayOfFloat[42];
    arrayOfFloat[119] = ((arrayOfFloat[116] + arrayOfFloat[117]) / 2.0F);
    arrayOfFloat[120] = ((arrayOfFloat[117] + arrayOfFloat[118]) / 2.0F);
    arrayOfFloat[121] = arrayOfFloat[45];
    arrayOfFloat[122] = arrayOfFloat[46];
    arrayOfFloat[123] = arrayOfFloat[47];
    arrayOfFloat[124] = arrayOfFloat[48];
    arrayOfFloat[125] = arrayOfFloat[49];
    arrayOfFloat[126] = arrayOfFloat[50];
    arrayOfFloat[127] = arrayOfFloat[51];
    arrayOfFloat[''] = arrayOfFloat[52];
    arrayOfFloat[''] = ((arrayOfFloat[126] + arrayOfFloat[127]) / 2.0F);
    arrayOfFloat[''] = ((arrayOfFloat[127] + arrayOfFloat['']) / 2.0F);
    return arrayOfFloat;
  }
  
  public static float[] getFullPointsVisForFaceOffFilter(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[''];
    int i = 0;
    while (i < 90)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i];
      i += 1;
    }
    arrayOfFloat[90] = arrayOfFloat[1];
    arrayOfFloat[91] = arrayOfFloat[17];
    arrayOfFloat[92] = 1.0F;
    arrayOfFloat[93] = 1.0F;
    arrayOfFloat[94] = 1.0F;
    arrayOfFloat[95] = 1.0F;
    arrayOfFloat[96] = 1.0F;
    arrayOfFloat[97] = 0.0F;
    arrayOfFloat[98] = 0.0F;
    arrayOfFloat[99] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[100] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[101] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[102] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[103] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[104] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[105] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[106] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[107] = ((arrayOfFloat[3] + arrayOfFloat[65]) / 2.0F);
    arrayOfFloat[108] = ((arrayOfFloat[15] + arrayOfFloat[66]) / 2.0F);
    arrayOfFloat[109] = ((arrayOfFloat[35] + arrayOfFloat[57]) / 2.0F);
    arrayOfFloat[110] = ((arrayOfFloat[45] + arrayOfFloat[61]) / 2.0F);
    arrayOfFloat[111] = arrayOfFloat[35];
    arrayOfFloat[112] = arrayOfFloat[36];
    arrayOfFloat[113] = arrayOfFloat[37];
    arrayOfFloat[114] = arrayOfFloat[38];
    arrayOfFloat[115] = arrayOfFloat[39];
    arrayOfFloat[116] = arrayOfFloat[40];
    arrayOfFloat[117] = arrayOfFloat[41];
    arrayOfFloat[118] = arrayOfFloat[42];
    arrayOfFloat[119] = ((arrayOfFloat[116] + arrayOfFloat[117]) / 2.0F);
    arrayOfFloat[120] = ((arrayOfFloat[117] + arrayOfFloat[118]) / 2.0F);
    arrayOfFloat[121] = arrayOfFloat[45];
    arrayOfFloat[122] = arrayOfFloat[46];
    arrayOfFloat[123] = arrayOfFloat[47];
    arrayOfFloat[124] = arrayOfFloat[48];
    arrayOfFloat[125] = arrayOfFloat[49];
    arrayOfFloat[126] = arrayOfFloat[50];
    arrayOfFloat[127] = arrayOfFloat[51];
    arrayOfFloat[''] = arrayOfFloat[52];
    arrayOfFloat[''] = ((arrayOfFloat[126] + arrayOfFloat[127]) / 2.0F);
    arrayOfFloat[''] = ((arrayOfFloat[127] + arrayOfFloat['']) / 2.0F);
    return arrayOfFloat;
  }
  
  public static float[] getFullPointsVisForFaceOffFilter_v2(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    return calcFullProbability_v2(paramList, paramArrayOfFloat, paramFloat);
  }
  
  public static Bitmap getGrayBitmap(FaceOffUtil.FeatureType paramFeatureType)
  {
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.NO_EYE)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NO_EYE, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.HAS_EYE)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_HAS_EYE, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.CRAZY_FACE)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_CRAZY_FACE, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.FACE_HEAD_CROP)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_CROP_HEAD_FACE, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.FACE_SKIN)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_FACE_SKIN, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.MASK)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_MASK, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.FACE_COS3D_MASK)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_FACE_COS3D_MASK, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.NOSE_MASK)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NOSE_MASK, 2147483647, 2147483647);
    }
    if (paramFeatureType.equals(FaceOffUtil.FeatureType.LIPS_MASK)) {
      return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_LIPS_MASK, 2147483647, 2147483647);
    }
    return null;
  }
  
  public static List<PointF> getGrayCoords(FaceOffUtil.FeatureType paramFeatureType)
  {
    int i = FaceOffUtil.1.$SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[paramFeatureType.ordinal()];
    String str = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    paramFeatureType = str;
    switch (i)
    {
    default: 
      paramFeatureType = str;
      break;
    case 4: 
      paramFeatureType = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
      break;
    case 3: 
      paramFeatureType = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
      break;
    case 2: 
      paramFeatureType = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
    }
    return loadTexCoords(paramFeatureType);
  }
  
  public static String getMaskBrushPointPath()
  {
    return DEFAULT_BRUSH_POINT;
  }
  
  public static List<PointF> getMaskCoords(List<Double> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size() - 1)
    {
      double d1 = ((Double)paramList.get(i)).doubleValue();
      double d2 = ((Double)paramList.get(i + 1)).doubleValue();
      localArrayList.add(new PointF((float)d1, (float)d2));
      i += 2;
    }
    return localArrayList;
  }
  
  public static List<PointF> getSelectedCorrectPoints(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt, List<PointF> paramList, float paramFloat)
  {
    paramArrayOfInt = new ArrayList();
    paramInt = 0;
    int i;
    float f1;
    float f2;
    for (;;)
    {
      i = 83;
      if (paramInt >= 83) {
        break;
      }
      Object localObject = Select3DIndices;
      f1 = paramArrayOfFloat1[(localObject[paramInt] * 3)];
      f2 = paramArrayOfFloat1[(localObject[paramInt] * 3 + 1)];
      float f3 = paramArrayOfFloat1[(localObject[paramInt] * 3 + 2)];
      localObject = new float[4];
      android.opengl.Matrix.multiplyMV((float[])localObject, 0, paramArrayOfFloat2, 0, new float[] { f1, f2, f3, 1.0F }, 0);
      paramArrayOfInt.add(new PointF(localObject[0], localObject[1]));
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt <= 18)
    {
      paramArrayOfInt.set(paramInt, new PointF(((PointF)paramList.get(paramInt)).x, ((PointF)paramList.get(paramInt)).y));
      paramInt += 1;
    }
    paramArrayOfInt.set(43, new PointF((((PointF)paramArrayOfInt.get(35)).x + ((PointF)paramArrayOfInt.get(39)).x) / 2.0F, (((PointF)paramArrayOfInt.get(35)).y + ((PointF)paramArrayOfInt.get(39)).y) / 2.0F));
    paramArrayOfInt.set(44, new PointF(((PointF)paramArrayOfInt.get(43)).x, ((PointF)paramArrayOfInt.get(43)).y));
    paramArrayOfInt.set(53, new PointF((((PointF)paramArrayOfInt.get(45)).x + ((PointF)paramArrayOfInt.get(49)).x) / 2.0F, (((PointF)paramArrayOfInt.get(45)).y + ((PointF)paramArrayOfInt.get(49)).y) / 2.0F));
    paramArrayOfInt.set(54, new PointF(((PointF)paramArrayOfInt.get(53)).x, ((PointF)paramArrayOfInt.get(53)).y));
    paramArrayOfInt.set(65, new PointF(((PointF)paramList.get(65)).x, ((PointF)paramList.get(65)).y));
    paramArrayOfInt.set(66, new PointF(((PointF)paramList.get(66)).x, ((PointF)paramList.get(66)).y));
    paramArrayOfInt = getFullCoordsForFaceOffFilter(FaceDetectUtil.facePointf83to90(paramArrayOfInt), paramFloat);
    paramInt = i;
    for (;;)
    {
      paramList = Select3DIndices;
      if (paramInt >= paramList.length) {
        break;
      }
      paramFloat = paramArrayOfFloat1[(paramList[paramInt] * 3)];
      f1 = paramArrayOfFloat1[(paramList[paramInt] * 3 + 1)];
      f2 = paramArrayOfFloat1[(paramList[paramInt] * 3 + 2)];
      paramList = new float[4];
      android.opengl.Matrix.multiplyMV(paramList, 0, paramArrayOfFloat2, 0, new float[] { paramFloat, f1, f2, 1.0F }, 0);
      paramArrayOfInt.set(paramInt + 28, new PointF(paramList[0], paramList[1]));
      paramInt += 1;
    }
    return paramArrayOfInt;
  }
  
  public static float[] initFaceLinePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 690)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
        float f2 = arrayOfPointF[0].x;
        float f1 = paramInt1;
        paramArrayOfFloat[j] = (f2 / f1 * 2.0F - 1.0F);
        f2 = arrayOfPointF[0].y;
        float f3 = paramInt2;
        paramArrayOfFloat[(j + 1)] = (f2 / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / f3 * 2.0F - 1.0F);
        j += 12;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFaceLinePositions_4_Smooth(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(faceMesh4Smooth[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(faceMesh4Smooth[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(faceMesh4Smooth[(i + 2)]));
        float f2 = arrayOfPointF[0].x;
        float f1 = paramInt1;
        paramArrayOfFloat[j] = (f2 / f1 * 2.0F - 1.0F);
        f2 = arrayOfPointF[0].y;
        float f3 = paramInt2;
        paramArrayOfFloat[(j + 1)] = (f2 / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / f3 * 2.0F - 1.0F);
        j += 12;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFaceLinePositions_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < NO_HOLE_TRIANGLE_COUNT_V2 * 3)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles_v2[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 2)]));
        float f2 = arrayOfPointF[0].x;
        float f1 = paramInt1;
        paramArrayOfFloat[j] = (f2 / f1 * 2.0F - 1.0F);
        f2 = arrayOfPointF[0].y;
        float f3 = paramInt2;
        paramArrayOfFloat[(j + 1)] = (f2 / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / f3 * 2.0F - 1.0F);
        j += 12;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFaceNoseLastPositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 1380))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 690)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(faceMeshNoseLastTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return initFacePositions(paramList, paramInt1, paramInt2, paramArrayOfFloat, null);
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat1 != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat1.length == 1380))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      int j = 0;
      while (i < 690)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
        float f3 = f1;
        int k = 0;
        f1 = f2;
        f2 = f3;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat1[m] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
          f2 += paramArrayOfFloat1[m];
          m += 1;
          paramArrayOfFloat1[m] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
          f1 += paramArrayOfFloat1[m];
          k += 1;
        }
        j += 6;
        i += 3;
        f3 = f1;
        f1 = f2;
        f2 = f3;
      }
      if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat2.length >= 2))
      {
        paramArrayOfFloat2[0] = f1;
        paramArrayOfFloat2[1] = f2;
      }
      return paramArrayOfFloat1;
    }
    return new float[0];
  }
  
  public static float[] initFacePositions4Smooth(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = paramInt3;
      paramInt3 = 0;
      while (paramInt3 < NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(faceMesh4Smooth[paramInt3]));
        arrayOfPointF[1] = ((PointF)paramList.get(faceMesh4Smooth[(paramInt3 + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(faceMesh4Smooth[(paramInt3 + 2)]));
        int j = 0;
        while (j < 3)
        {
          int k = j * 2 + i;
          paramArrayOfFloat[k] = (arrayOfPointF[j].x / paramInt1 * 2.0F - 1.0F);
          paramArrayOfFloat[(k + 1)] = (arrayOfPointF[j].y / paramInt2 * 2.0F - 1.0F);
          j += 1;
        }
        i += 6;
        paramInt3 += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFacePositionsBaseOnFaceRect(List<PointF> paramList, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramFloat1 > 0.0F) && (paramFloat2 > 0.0F) && (paramArrayOfFloat.length == 1380))
    {
      int j = paramList.size();
      float f1 = ((PointF)paramList.get(64)).x;
      float f2 = ((PointF)paramList.get(64)).y;
      int i = 0;
      while (i < j)
      {
        ((PointF)paramList.get(i)).x -= f1;
        ((PointF)paramList.get(i)).y -= f2;
        i += 1;
      }
      PointF[] arrayOfPointF = new PointF[3];
      i = 0;
      j = 0;
      while (i < 690)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramFloat1 * 2.0F);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramFloat2 * 2.0F);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFacePositionsFaceAverage(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 1104))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 552)
      {
        if (paramInt3 != 0)
        {
          if (paramInt3 == 1)
          {
            arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[i]));
            arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 1)]));
            arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 2)]));
          }
        }
        else
        {
          arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[i]));
          arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 1)]));
          arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 2)]));
        }
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initFacePositions_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return initFacePositions_v2(paramList, paramInt1, paramInt2, paramArrayOfFloat, null);
  }
  
  public static float[] initFacePositions_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat1 != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat1.length == NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      int j = 0;
      while (i < NO_HOLE_TRIANGLE_COUNT_V2 * 3)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles_v2[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 2)]));
        float f3 = f1;
        int k = 0;
        f1 = f2;
        f2 = f3;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat1[m] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
          f2 += paramArrayOfFloat1[m];
          m += 1;
          paramArrayOfFloat1[m] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
          f1 += paramArrayOfFloat1[m];
          k += 1;
        }
        j += 6;
        i += 3;
        f3 = f1;
        f1 = f2;
        f2 = f3;
      }
      if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat2.length >= 2))
      {
        paramArrayOfFloat2[0] = f1;
        paramArrayOfFloat2[1] = f2;
      }
      return paramArrayOfFloat1;
    }
    return new float[0];
  }
  
  public static float[] initFaceTexCoords4Smooth(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(faceMesh4Smooth[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(faceMesh4Smooth[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(faceMesh4Smooth[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initIrisLinePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 24)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(IrisMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(IrisMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(IrisMeshTriangles[(i + 2)]));
        float f2 = arrayOfPointF[0].x;
        float f1 = paramInt1;
        paramArrayOfFloat[j] = (f2 / f1 * 2.0F - 1.0F);
        f2 = arrayOfPointF[0].y;
        float f3 = paramInt2;
        paramArrayOfFloat[(j + 1)] = (f2 / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / f3 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / f1 * 2.0F - 1.0F);
        paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / f3 * 2.0F - 1.0F);
        j += 12;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initMaterialFaceNoseLastTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 1380))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 690)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(faceMeshNoseLastTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initMaterialFaceTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 1380))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 690)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initMaterialFaceTexCoordsFaceAverage(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == 1104))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < 552)
      {
        if (paramInt3 != 0)
        {
          if (paramInt3 == 1)
          {
            arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[i]));
            arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 1)]));
            arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 2)]));
          }
        }
        else
        {
          arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[i]));
          arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 1)]));
          arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 2)]));
        }
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initMaterialFaceTexCoords_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramInt1 > 0) && (paramInt2 > 0) && (paramArrayOfFloat.length == NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2))
    {
      PointF[] arrayOfPointF = new PointF[3];
      int i = 0;
      int j = 0;
      while (i < NO_HOLE_TRIANGLE_COUNT_V2 * 3)
      {
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles_v2[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 2)]));
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat[m] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(m + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat;
    }
    return new float[0];
  }
  
  public static float[] initPointVis(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2.length == 1380))
    {
      float[] arrayOfFloat = new float[3];
      int i = 0;
      int j = 0;
      while (i < 690)
      {
        int[] arrayOfInt = FaceMeshTriangles;
        arrayOfFloat[0] = paramArrayOfFloat1[arrayOfInt[i]];
        arrayOfFloat[1] = paramArrayOfFloat1[arrayOfInt[(i + 1)]];
        arrayOfFloat[2] = paramArrayOfFloat1[arrayOfInt[(i + 2)]];
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat2[m] = arrayOfFloat[k];
          paramArrayOfFloat2[(m + 1)] = arrayOfFloat[k];
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat2;
    }
    return new float[0];
  }
  
  public static float[] initPointVis_v2(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2.length == NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2))
    {
      float[] arrayOfFloat = new float[3];
      int i = 0;
      int j = 0;
      while (i < NO_HOLE_TRIANGLE_COUNT_V2 * 3)
      {
        int[] arrayOfInt = FaceMeshTriangles_v2;
        arrayOfFloat[0] = paramArrayOfFloat1[arrayOfInt[i]];
        arrayOfFloat[1] = paramArrayOfFloat1[arrayOfInt[(i + 1)]];
        arrayOfFloat[2] = paramArrayOfFloat1[arrayOfInt[(i + 2)]];
        int k = 0;
        while (k < 3)
        {
          int m = k * 2 + j;
          paramArrayOfFloat2[m] = arrayOfFloat[k];
          paramArrayOfFloat2[(m + 1)] = arrayOfFloat[k];
          k += 1;
        }
        j += 6;
        i += 3;
      }
      return paramArrayOfFloat2;
    }
    return new float[0];
  }
  
  public static List<PointF> loadTexCoords(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    return loadTexCoords(paramString.substring(0, paramString.lastIndexOf(File.separator)), paramString.substring(paramString.lastIndexOf(File.separator) + 1));
  }
  
  private static List<PointF> loadTexCoords(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return localArrayList;
      }
      paramString1 = FileUtils.load(AEModule.getContext(), paramString1, paramString2);
      if (paramString1 == null) {
        return localArrayList;
      }
      paramString1 = paramString1.trim().split("\\s+");
      int i = 0;
      try
      {
        while (i < paramString1.length / 2)
        {
          int j = i * 2;
          localArrayList.add(new PointF(Float.parseFloat(paramString1[j]), Float.parseFloat(paramString1[(j + 1)])));
          i += 1;
        }
        return localArrayList;
      }
      catch (NumberFormatException paramString1)
      {
        LogUtils.e(TAG, paramString1.toString());
        return new ArrayList();
      }
    }
    return localArrayList;
  }
  
  public static native void nativeGetFullCoords(Object paramObject1, int paramInt, float paramFloat, Object paramObject2);
  
  public static void recycleCrazySkinMergeBitmap()
  {
    BitmapUtils.recycle(crazySkinMergeBitmap);
  }
  
  public static void scalePoints(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      double d = localPointF.x;
      Double.isNaN(d);
      localPointF.x = ((float)(d * paramDouble));
      d = localPointF.y;
      Double.isNaN(d);
      localPointF.y = ((float)(d * paramDouble));
    }
  }
  
  public static void setCrazyFacePath(String paramString)
  {
    GRAY_FILE_CRAZY_FACE = paramString;
  }
  
  public static void setCrazyLipsMaskPath(String paramString)
  {
    GRAY_FILE_LIPS_MASK = paramString;
  }
  
  public static void setCrazyMaskCos3DPath(String paramString)
  {
    GRAY_FILE_FACE_COS3D_MASK = paramString;
  }
  
  public static void setCrazyMaskPath(String paramString)
  {
    GRAY_FILE_MASK = paramString;
  }
  
  public static void setCropHeadFacePath(String paramString)
  {
    GRAY_FILE_CROP_HEAD_FACE = paramString;
  }
  
  public static void setFaceMaskSkinPath(String paramString)
  {
    GRAY_FILE_FACE_SKIN = paramString;
  }
  
  public static void setGrayFileNoseMask(String paramString)
  {
    GRAY_FILE_NOSE_MASK = paramString;
  }
  
  public static void setMaskBrushPointPath(String paramString)
  {
    DEFAULT_BRUSH_POINT = paramString;
  }
  
  public static void setNoEyeGrayImagePath(String paramString)
  {
    GRAY_FILE_HAS_EYE = paramString;
  }
  
  public static void setNoMouthGrayImagePath(String paramString)
  {
    GRAY_FILE_NO_EYE = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceOffUtil
 * JD-Core Version:    0.7.0.1
 */