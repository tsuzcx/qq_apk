package org.jbox2d.collision;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.IWorldPool;

public class Collision
{
  public static final int NULL_FEATURE = 2147483647;
  private static Vec2 d = new Vec2();
  private final Vec2 P = new Vec2();
  private final Vec2 Q = new Vec2();
  private final Distance.SimplexCache cache = new Distance.SimplexCache();
  private final ContactID cf = new ContactID();
  private final Collision.ClipVertex[] clipPoints1 = new Collision.ClipVertex[2];
  private final Collision.ClipVertex[] clipPoints2 = new Collision.ClipVertex[2];
  private final Collision.EPCollider collider = new Collision.EPCollider();
  private final Vec2 e = new Vec2();
  private final Vec2 e1 = new Vec2();
  private final Collision.ClipVertex[] incidentEdge = new Collision.ClipVertex[2];
  private final DistanceInput input = new DistanceInput();
  private final Vec2 localNormal = new Vec2();
  private final Vec2 localTangent = new Vec2();
  private final Vec2 n = new Vec2();
  private final DistanceOutput output = new DistanceOutput();
  private final Vec2 planePoint = new Vec2();
  private final IWorldPool pool;
  private final Collision.EdgeResults results1 = new Collision.EdgeResults(null);
  private final Collision.EdgeResults results2 = new Collision.EdgeResults(null);
  private final Vec2 tangent = new Vec2();
  private final Vec2 temp = new Vec2();
  private final Vec2 v11 = new Vec2();
  private final Vec2 v12 = new Vec2();
  
  public Collision(IWorldPool paramIWorldPool)
  {
    this.incidentEdge[0] = new Collision.ClipVertex();
    this.incidentEdge[1] = new Collision.ClipVertex();
    this.clipPoints1[0] = new Collision.ClipVertex();
    this.clipPoints1[1] = new Collision.ClipVertex();
    this.clipPoints2[0] = new Collision.ClipVertex();
    this.clipPoints2[1] = new Collision.ClipVertex();
    this.pool = paramIWorldPool;
  }
  
  public static final int clipSegmentToLine(Collision.ClipVertex[] paramArrayOfClipVertex1, Collision.ClipVertex[] paramArrayOfClipVertex2, Vec2 paramVec2, float paramFloat, int paramInt)
  {
    int j = 0;
    Collision.ClipVertex localClipVertex1 = paramArrayOfClipVertex2[0];
    Collision.ClipVertex localClipVertex2 = paramArrayOfClipVertex2[1];
    paramArrayOfClipVertex2 = localClipVertex1.v;
    Vec2 localVec2 = localClipVertex2.v;
    float f = Vec2.dot(paramVec2, paramArrayOfClipVertex2) - paramFloat;
    paramFloat = Vec2.dot(paramVec2, localVec2) - paramFloat;
    if (f <= 0.0F)
    {
      paramArrayOfClipVertex1[0].set(localClipVertex1);
      j = 1;
    }
    int i = j;
    if (paramFloat <= 0.0F)
    {
      paramArrayOfClipVertex1[j].set(localClipVertex2);
      i = j + 1;
    }
    j = i;
    if (f * paramFloat < 0.0F)
    {
      paramFloat = f / (f - paramFloat);
      paramArrayOfClipVertex1 = paramArrayOfClipVertex1[i];
      paramArrayOfClipVertex1.v.x = (paramArrayOfClipVertex2.x + (localVec2.x - paramArrayOfClipVertex2.x) * paramFloat);
      paramArrayOfClipVertex1.v.y = (paramArrayOfClipVertex2.y + paramFloat * (localVec2.y - paramArrayOfClipVertex2.y));
      paramArrayOfClipVertex1.id.indexA = ((byte)paramInt);
      paramArrayOfClipVertex1.id.indexB = localClipVertex1.id.indexB;
      paramArrayOfClipVertex1.id.typeA = ((byte)ContactID.Type.VERTEX.ordinal());
      paramArrayOfClipVertex1.id.typeB = ((byte)ContactID.Type.FACE.ordinal());
      j = i + 1;
    }
    return j;
  }
  
  public static final void getPointStates(Collision.PointState[] paramArrayOfPointState1, Collision.PointState[] paramArrayOfPointState2, Manifold paramManifold1, Manifold paramManifold2)
  {
    int i = 0;
    while (i < 2)
    {
      paramArrayOfPointState1[i] = Collision.PointState.NULL_STATE;
      paramArrayOfPointState2[i] = Collision.PointState.NULL_STATE;
      i += 1;
    }
    i = 0;
    int j;
    while (i < paramManifold1.pointCount)
    {
      ContactID localContactID = paramManifold1.points[i].id;
      paramArrayOfPointState1[i] = Collision.PointState.REMOVE_STATE;
      j = 0;
      while (j < paramManifold2.pointCount)
      {
        if (paramManifold2.points[j].id.isEqual(localContactID))
        {
          paramArrayOfPointState1[i] = Collision.PointState.PERSIST_STATE;
          break;
        }
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < paramManifold2.pointCount)
    {
      paramArrayOfPointState1 = paramManifold2.points[i].id;
      paramArrayOfPointState2[i] = Collision.PointState.ADD_STATE;
      j = 0;
      while (j < paramManifold1.pointCount)
      {
        if (paramManifold1.points[j].id.isEqual(paramArrayOfPointState1))
        {
          paramArrayOfPointState2[i] = Collision.PointState.PERSIST_STATE;
          break;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public final void collideCircles(Manifold paramManifold, CircleShape paramCircleShape1, Transform paramTransform1, CircleShape paramCircleShape2, Transform paramTransform2)
  {
    paramManifold.pointCount = 0;
    Vec2 localVec21 = paramCircleShape1.m_p;
    Vec2 localVec22 = paramCircleShape2.m_p;
    float f11 = paramTransform1.q.c;
    float f12 = localVec21.x;
    float f13 = paramTransform1.q.s;
    float f14 = localVec21.y;
    float f15 = paramTransform1.p.x;
    float f1 = paramTransform1.q.s;
    float f2 = localVec21.x;
    float f3 = paramTransform1.q.c;
    float f4 = localVec21.y;
    float f5 = paramTransform1.p.y;
    float f16 = paramTransform2.q.c;
    float f17 = localVec22.x;
    float f18 = paramTransform2.q.s;
    float f19 = localVec22.y;
    float f20 = paramTransform2.p.x;
    float f6 = paramTransform2.q.s;
    float f7 = localVec22.x;
    float f8 = paramTransform2.q.c;
    float f9 = localVec22.y;
    float f10 = paramTransform2.p.y;
    f11 = f16 * f17 - f18 * f19 + f20 - (f11 * f12 - f13 * f14 + f15);
    f1 = f6 * f7 + f8 * f9 + f10 - (f1 * f2 + f3 * f4 + f5);
    f2 = paramCircleShape1.m_radius + paramCircleShape2.m_radius;
    if (f11 * f11 + f1 * f1 > f2 * f2) {
      return;
    }
    paramManifold.type = Manifold.ManifoldType.CIRCLES;
    paramManifold.localPoint.set(localVec21);
    paramManifold.localNormal.setZero();
    paramManifold.pointCount = 1;
    paramManifold.points[0].localPoint.set(localVec22);
    paramManifold.points[0].id.zero();
  }
  
  public void collideEdgeAndCircle(Manifold paramManifold, EdgeShape paramEdgeShape, Transform paramTransform1, CircleShape paramCircleShape, Transform paramTransform2)
  {
    paramManifold.pointCount = 0;
    Transform.mulToOutUnsafe(paramTransform2, paramCircleShape.m_p, this.temp);
    Transform.mulTransToOutUnsafe(paramTransform1, this.temp, this.Q);
    paramTransform1 = paramEdgeShape.m_vertex1;
    paramTransform2 = paramEdgeShape.m_vertex2;
    this.e.set(paramTransform2).subLocal(paramTransform1);
    float f1 = Vec2.dot(this.e, this.temp.set(paramTransform2).subLocal(this.Q));
    float f2 = Vec2.dot(this.e, this.temp.set(this.Q).subLocal(paramTransform1));
    float f3 = paramEdgeShape.m_radius + paramCircleShape.m_radius;
    ContactID localContactID = this.cf;
    localContactID.indexB = 0;
    localContactID.typeB = ((byte)ContactID.Type.VERTEX.ordinal());
    if (f2 <= 0.0F)
    {
      d.set(this.Q).subLocal(paramTransform1);
      paramTransform2 = d;
      if (Vec2.dot(paramTransform2, paramTransform2) > f3 * f3) {
        return;
      }
      if (paramEdgeShape.m_hasVertex0)
      {
        paramEdgeShape = paramEdgeShape.m_vertex0;
        this.e1.set(paramTransform1).subLocal(paramEdgeShape);
        if (Vec2.dot(this.e1, this.temp.set(paramTransform1).subLocal(this.Q)) > 0.0F) {
          return;
        }
      }
      paramEdgeShape = this.cf;
      paramEdgeShape.indexA = 0;
      paramEdgeShape.typeA = ((byte)ContactID.Type.VERTEX.ordinal());
      paramManifold.pointCount = 1;
      paramManifold.type = Manifold.ManifoldType.CIRCLES;
      paramManifold.localNormal.setZero();
      paramManifold.localPoint.set(paramTransform1);
      paramManifold.points[0].id.set(this.cf);
      paramManifold.points[0].localPoint.set(paramCircleShape.m_p);
      return;
    }
    if (f1 <= 0.0F)
    {
      d.set(this.Q).subLocal(paramTransform2);
      paramTransform1 = d;
      if (Vec2.dot(paramTransform1, paramTransform1) > f3 * f3) {
        return;
      }
      if (paramEdgeShape.m_hasVertex3)
      {
        paramEdgeShape = paramEdgeShape.m_vertex3;
        paramTransform1 = this.e1;
        paramTransform1.set(paramEdgeShape).subLocal(paramTransform2);
        if (Vec2.dot(paramTransform1, this.temp.set(this.Q).subLocal(paramTransform2)) > 0.0F) {
          return;
        }
      }
      paramEdgeShape = this.cf;
      paramEdgeShape.indexA = 1;
      paramEdgeShape.typeA = ((byte)ContactID.Type.VERTEX.ordinal());
      paramManifold.pointCount = 1;
      paramManifold.type = Manifold.ManifoldType.CIRCLES;
      paramManifold.localNormal.setZero();
      paramManifold.localPoint.set(paramTransform2);
      paramManifold.points[0].id.set(this.cf);
      paramManifold.points[0].localPoint.set(paramCircleShape.m_p);
      return;
    }
    paramEdgeShape = this.e;
    float f4 = Vec2.dot(paramEdgeShape, paramEdgeShape);
    this.P.set(paramTransform1).mulLocal(f1).addLocal(this.temp.set(paramTransform2).mulLocal(f2));
    this.P.mulLocal(1.0F / f4);
    d.set(this.Q).subLocal(this.P);
    paramEdgeShape = d;
    if (Vec2.dot(paramEdgeShape, paramEdgeShape) > f3 * f3) {
      return;
    }
    this.n.x = (-this.e.y);
    this.n.y = this.e.x;
    if (Vec2.dot(this.n, this.temp.set(this.Q).subLocal(paramTransform1)) < 0.0F)
    {
      paramEdgeShape = this.n;
      paramEdgeShape.set(-paramEdgeShape.x, -this.n.y);
    }
    this.n.normalize();
    paramEdgeShape = this.cf;
    paramEdgeShape.indexA = 0;
    paramEdgeShape.typeA = ((byte)ContactID.Type.FACE.ordinal());
    paramManifold.pointCount = 1;
    paramManifold.type = Manifold.ManifoldType.FACE_A;
    paramManifold.localNormal.set(this.n);
    paramManifold.localPoint.set(paramTransform1);
    paramManifold.points[0].id.set(this.cf);
    paramManifold.points[0].localPoint.set(paramCircleShape.m_p);
  }
  
  public void collideEdgeAndPolygon(Manifold paramManifold, EdgeShape paramEdgeShape, Transform paramTransform1, PolygonShape paramPolygonShape, Transform paramTransform2)
  {
    this.collider.collide(paramManifold, paramEdgeShape, paramTransform1, paramPolygonShape, paramTransform2);
  }
  
  public final void collidePolygonAndCircle(Manifold paramManifold, PolygonShape paramPolygonShape, Transform paramTransform1, CircleShape paramCircleShape, Transform paramTransform2)
  {
    paramManifold.pointCount = 0;
    Vec2 localVec2 = paramCircleShape.m_p;
    Rot localRot1 = paramTransform2.q;
    Rot localRot2 = paramTransform1.q;
    float f6 = localRot1.c;
    float f7 = localVec2.x;
    float f8 = localRot1.s;
    float f9 = localVec2.y;
    float f10 = paramTransform2.p.x;
    float f1 = localRot1.s;
    float f2 = localVec2.x;
    float f3 = localRot1.c;
    float f4 = localVec2.y;
    float f5 = paramTransform2.p.y;
    f6 = f6 * f7 - f8 * f9 + f10 - paramTransform1.p.x;
    f1 = f1 * f2 + f3 * f4 + f5 - paramTransform1.p.y;
    f4 = localRot2.c * f6 + localRot2.s * f1;
    f5 = -localRot2.s * f6 + localRot2.c * f1;
    f6 = paramPolygonShape.m_radius + paramCircleShape.m_radius;
    int k = paramPolygonShape.m_count;
    paramTransform1 = paramPolygonShape.m_vertices;
    paramPolygonShape = paramPolygonShape.m_normals;
    int i = 0;
    int j = 0;
    for (f1 = -3.402824E+038F; i < k; f1 = f2)
    {
      paramCircleShape = paramTransform1[i];
      f2 = paramCircleShape.x;
      f3 = paramCircleShape.y;
      f3 = paramPolygonShape[i].x * (f4 - f2) + paramPolygonShape[i].y * (f5 - f3);
      if (f3 > f6) {
        return;
      }
      f2 = f1;
      if (f3 > f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
    }
    i = j + 1;
    if (i >= k) {
      i = 0;
    }
    paramCircleShape = paramTransform1[j];
    paramTransform1 = paramTransform1[i];
    if (f1 < 1.192093E-007F)
    {
      paramManifold.pointCount = 1;
      paramManifold.type = Manifold.ManifoldType.FACE_A;
      paramPolygonShape = paramPolygonShape[j];
      paramManifold.localNormal.x = paramPolygonShape.x;
      paramManifold.localNormal.y = paramPolygonShape.y;
      paramManifold.localPoint.x = ((paramCircleShape.x + paramTransform1.x) * 0.5F);
      paramManifold.localPoint.y = ((paramCircleShape.y + paramTransform1.y) * 0.5F);
      paramManifold = paramManifold.points[0];
      paramManifold.localPoint.x = localVec2.x;
      paramManifold.localPoint.y = localVec2.y;
      paramManifold.id.zero();
      return;
    }
    f1 = paramCircleShape.x;
    f2 = paramCircleShape.y;
    f3 = paramTransform1.x;
    f7 = paramCircleShape.x;
    f8 = paramTransform1.y;
    f9 = paramCircleShape.y;
    f10 = paramTransform1.x;
    float f11 = paramTransform1.y;
    float f12 = paramCircleShape.x;
    float f13 = paramTransform1.x;
    float f14 = paramCircleShape.y;
    float f15 = paramTransform1.y;
    if ((f4 - f1) * (f3 - f7) + (f5 - f2) * (f8 - f9) <= 0.0F)
    {
      f1 = f4 - paramCircleShape.x;
      f2 = f5 - paramCircleShape.y;
      if (f1 * f1 + f2 * f2 > f6 * f6) {
        return;
      }
      paramManifold.pointCount = 1;
      paramManifold.type = Manifold.ManifoldType.FACE_A;
      paramManifold.localNormal.x = (f4 - paramCircleShape.x);
      paramManifold.localNormal.y = (f5 - paramCircleShape.y);
      paramManifold.localNormal.normalize();
      paramManifold.localPoint.set(paramCircleShape);
      paramManifold.points[0].localPoint.set(localVec2);
      paramManifold.points[0].id.zero();
      return;
    }
    if ((f4 - f10) * (f12 - f13) + (f5 - f11) * (f14 - f15) <= 0.0F)
    {
      f1 = f4 - paramTransform1.x;
      f2 = f5 - paramTransform1.y;
      if (f1 * f1 + f2 * f2 > f6 * f6) {
        return;
      }
      paramManifold.pointCount = 1;
      paramManifold.type = Manifold.ManifoldType.FACE_A;
      paramManifold.localNormal.x = (f4 - paramTransform1.x);
      paramManifold.localNormal.y = (f5 - paramTransform1.y);
      paramManifold.localNormal.normalize();
      paramManifold.localPoint.set(paramTransform1);
      paramManifold.points[0].localPoint.set(localVec2);
      paramManifold.points[0].id.zero();
      return;
    }
    f1 = (paramCircleShape.x + paramTransform1.x) * 0.5F;
    f2 = (paramCircleShape.y + paramTransform1.y) * 0.5F;
    paramTransform1 = paramPolygonShape[j];
    if ((f4 - f1) * paramTransform1.x + (f5 - f2) * paramTransform1.y > f6) {
      return;
    }
    paramManifold.pointCount = 1;
    paramManifold.type = Manifold.ManifoldType.FACE_A;
    paramManifold.localNormal.set(paramPolygonShape[j]);
    paramManifold.localPoint.x = f1;
    paramManifold.localPoint.y = f2;
    paramManifold.points[0].localPoint.set(localVec2);
    paramManifold.points[0].id.zero();
  }
  
  public final void collidePolygons(Manifold paramManifold, PolygonShape paramPolygonShape1, Transform paramTransform1, PolygonShape paramPolygonShape2, Transform paramTransform2)
  {
    paramManifold.pointCount = 0;
    float f1 = paramPolygonShape1.m_radius + paramPolygonShape2.m_radius;
    findMaxSeparation(this.results1, paramPolygonShape1, paramTransform1, paramPolygonShape2, paramTransform2);
    if (this.results1.separation > f1) {
      return;
    }
    findMaxSeparation(this.results2, paramPolygonShape2, paramTransform2, paramPolygonShape1, paramTransform1);
    if (this.results2.separation > f1) {
      return;
    }
    int i;
    if (this.results2.separation > this.results1.separation * 0.98F + 0.001F)
    {
      j = this.results2.edgeIndex;
      paramManifold.type = Manifold.ManifoldType.FACE_B;
      localObject = paramTransform1;
      paramTransform1 = paramPolygonShape1;
      paramPolygonShape1 = paramPolygonShape2;
      i = 1;
      paramPolygonShape2 = paramTransform1;
      paramTransform1 = paramTransform2;
      paramTransform2 = paramPolygonShape1;
      paramPolygonShape1 = (PolygonShape)localObject;
    }
    else
    {
      j = this.results1.edgeIndex;
      paramManifold.type = Manifold.ManifoldType.FACE_A;
      localObject = paramPolygonShape1;
      i = 0;
      paramPolygonShape1 = paramTransform2;
      paramTransform2 = (Transform)localObject;
    }
    Object localObject = paramTransform1.q;
    findIncidentEdge(this.incidentEdge, paramTransform2, paramTransform1, j, paramPolygonShape2, paramPolygonShape1);
    int m = paramTransform2.m_count;
    paramPolygonShape2 = paramTransform2.m_vertices;
    int k = j + 1;
    if (k >= m) {
      k = 0;
    }
    this.v11.set(paramPolygonShape2[j]);
    this.v12.set(paramPolygonShape2[k]);
    this.localTangent.x = (this.v12.x - this.v11.x);
    this.localTangent.y = (this.v12.y - this.v11.y);
    this.localTangent.normalize();
    this.localNormal.x = (this.localTangent.y * 1.0F);
    this.localNormal.y = (this.localTangent.x * -1.0F);
    this.planePoint.x = ((this.v11.x + this.v12.x) * 0.5F);
    this.planePoint.y = ((this.v11.y + this.v12.y) * 0.5F);
    this.tangent.x = (((Rot)localObject).c * this.localTangent.x - ((Rot)localObject).s * this.localTangent.y);
    this.tangent.y = (((Rot)localObject).s * this.localTangent.x + ((Rot)localObject).c * this.localTangent.y);
    float f2 = this.tangent.y * 1.0F;
    float f3 = this.tangent.x * -1.0F;
    paramPolygonShape2 = this.v11;
    Transform.mulToOut(paramTransform1, paramPolygonShape2, paramPolygonShape2);
    paramPolygonShape2 = this.v12;
    Transform.mulToOut(paramTransform1, paramPolygonShape2, paramPolygonShape2);
    float f4 = this.v11.x;
    float f5 = this.v11.y;
    float f6 = -(this.tangent.x * this.v11.x + this.tangent.y * this.v11.y);
    float f7 = this.tangent.x;
    float f8 = this.v12.x;
    float f9 = this.tangent.y;
    float f10 = this.v12.y;
    this.tangent.negateLocal();
    int j = clipSegmentToLine(this.clipPoints1, this.incidentEdge, this.tangent, f6 + f1, j);
    this.tangent.negateLocal();
    if (j < 2) {
      return;
    }
    if (clipSegmentToLine(this.clipPoints2, this.clipPoints1, this.tangent, f7 * f8 + f9 * f10 + f1, k) < 2) {
      return;
    }
    paramManifold.localNormal.set(this.localNormal);
    paramManifold.localPoint.set(this.planePoint);
    j = 0;
    for (k = 0; j < 2; k = m)
    {
      m = k;
      if (this.clipPoints2[j].v.x * f2 + this.clipPoints2[j].v.y * f3 - (f4 * f2 + f5 * f3) <= f1)
      {
        paramTransform1 = paramManifold.points[k];
        paramPolygonShape2 = paramTransform1.localPoint;
        f6 = this.clipPoints2[j].v.x - paramPolygonShape1.p.x;
        f7 = this.clipPoints2[j].v.y - paramPolygonShape1.p.y;
        paramPolygonShape2.x = (paramPolygonShape1.q.c * f6 + paramPolygonShape1.q.s * f7);
        paramPolygonShape2.y = (-paramPolygonShape1.q.s * f6 + paramPolygonShape1.q.c * f7);
        paramTransform1.id.set(this.clipPoints2[j].id);
        if (i != 0) {
          paramTransform1.id.flip();
        }
        m = k + 1;
      }
      j += 1;
    }
    paramManifold.pointCount = k;
  }
  
  public final float edgeSeparation(PolygonShape paramPolygonShape1, Transform paramTransform1, int paramInt, PolygonShape paramPolygonShape2, Transform paramTransform2)
  {
    int i = paramPolygonShape1.m_count;
    Object localObject1 = paramPolygonShape1.m_vertices;
    Object localObject2 = paramPolygonShape1.m_normals;
    int k = paramPolygonShape2.m_count;
    paramPolygonShape2 = paramPolygonShape2.m_vertices;
    Rot localRot = paramTransform1.q;
    paramPolygonShape1 = paramTransform2.q;
    localObject2 = localObject2[paramInt];
    float f4 = localRot.c * ((Vec2)localObject2).x - localRot.s * ((Vec2)localObject2).y;
    float f5 = localRot.s * ((Vec2)localObject2).x + localRot.c * ((Vec2)localObject2).y;
    float f6 = paramPolygonShape1.c;
    float f7 = paramPolygonShape1.s;
    float f8 = -paramPolygonShape1.s;
    float f9 = paramPolygonShape1.c;
    i = 0;
    int j = 0;
    for (float f1 = 3.4028235E+38F; i < k; f1 = f2)
    {
      localObject2 = paramPolygonShape2[i];
      f3 = ((Vec2)localObject2).x * (f6 * f4 + f7 * f5) + ((Vec2)localObject2).y * (f8 * f4 + f9 * f5);
      f2 = f1;
      if (f3 < f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
    }
    localObject1 = localObject1[paramInt];
    f1 = localRot.c;
    float f2 = ((Vec2)localObject1).x;
    float f3 = localRot.s;
    f6 = ((Vec2)localObject1).y;
    f7 = paramTransform1.p.x;
    f8 = localRot.s;
    f9 = ((Vec2)localObject1).x;
    float f10 = localRot.c;
    float f11 = ((Vec2)localObject1).y;
    float f12 = paramTransform1.p.y;
    paramTransform1 = paramPolygonShape2[j];
    return (paramPolygonShape1.c * paramTransform1.x - paramPolygonShape1.s * paramTransform1.y + paramTransform2.p.x - (f1 * f2 - f3 * f6 + f7)) * f4 + (paramPolygonShape1.s * paramTransform1.x + paramPolygonShape1.c * paramTransform1.y + paramTransform2.p.y - (f8 * f9 + f10 * f11 + f12)) * f5;
  }
  
  public final void findIncidentEdge(Collision.ClipVertex[] paramArrayOfClipVertex, PolygonShape paramPolygonShape1, Transform paramTransform1, int paramInt, PolygonShape paramPolygonShape2, Transform paramTransform2)
  {
    int i = paramPolygonShape1.m_count;
    Object localObject2 = paramPolygonShape1.m_normals;
    int k = paramPolygonShape2.m_count;
    paramPolygonShape1 = paramPolygonShape2.m_vertices;
    Object localObject1 = paramPolygonShape2.m_normals;
    paramPolygonShape2 = paramArrayOfClipVertex[0];
    paramArrayOfClipVertex = paramArrayOfClipVertex[1];
    Rot localRot = paramTransform1.q;
    paramTransform1 = paramTransform2.q;
    localObject2 = localObject2[paramInt];
    float f4 = localRot.c * ((Vec2)localObject2).x - localRot.s * ((Vec2)localObject2).y;
    float f5 = localRot.s * ((Vec2)localObject2).x + localRot.c * ((Vec2)localObject2).y;
    float f6 = paramTransform1.c;
    float f7 = paramTransform1.s;
    float f8 = -paramTransform1.s;
    float f9 = paramTransform1.c;
    i = 0;
    int j = 0;
    float f2;
    for (float f1 = 3.4028235E+38F; i < k; f1 = f2)
    {
      localObject2 = localObject1[i];
      float f3 = ((Vec2)localObject2).x * (f6 * f4 + f7 * f5) + ((Vec2)localObject2).y * (f8 * f4 + f9 * f5);
      f2 = f1;
      if (f3 < f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
    }
    i = j + 1;
    if (i >= k) {
      i = 0;
    }
    localObject1 = paramPolygonShape1[j];
    localObject2 = paramPolygonShape2.v;
    ((Vec2)localObject2).x = (paramTransform1.c * ((Vec2)localObject1).x - paramTransform1.s * ((Vec2)localObject1).y + paramTransform2.p.x);
    ((Vec2)localObject2).y = (paramTransform1.s * ((Vec2)localObject1).x + paramTransform1.c * ((Vec2)localObject1).y + paramTransform2.p.y);
    localObject1 = paramPolygonShape2.id;
    byte b = (byte)paramInt;
    ((ContactID)localObject1).indexA = b;
    paramPolygonShape2.id.indexB = ((byte)j);
    paramPolygonShape2.id.typeA = ((byte)ContactID.Type.FACE.ordinal());
    paramPolygonShape2.id.typeB = ((byte)ContactID.Type.VERTEX.ordinal());
    paramPolygonShape1 = paramPolygonShape1[i];
    paramPolygonShape2 = paramArrayOfClipVertex.v;
    paramPolygonShape2.x = (paramTransform1.c * paramPolygonShape1.x - paramTransform1.s * paramPolygonShape1.y + paramTransform2.p.x);
    paramPolygonShape2.y = (paramTransform1.s * paramPolygonShape1.x + paramTransform1.c * paramPolygonShape1.y + paramTransform2.p.y);
    paramArrayOfClipVertex.id.indexA = b;
    paramArrayOfClipVertex.id.indexB = ((byte)i);
    paramArrayOfClipVertex.id.typeA = ((byte)ContactID.Type.FACE.ordinal());
    paramArrayOfClipVertex.id.typeB = ((byte)ContactID.Type.VERTEX.ordinal());
  }
  
  public final void findMaxSeparation(Collision.EdgeResults paramEdgeResults, PolygonShape paramPolygonShape1, Transform paramTransform1, PolygonShape paramPolygonShape2, Transform paramTransform2)
  {
    int i1 = paramPolygonShape1.m_count;
    Vec2[] arrayOfVec2 = paramPolygonShape1.m_normals;
    Vec2 localVec21 = paramPolygonShape1.m_centroid;
    Vec2 localVec22 = paramPolygonShape2.m_centroid;
    Rot localRot1 = paramTransform2.q;
    Rot localRot2 = paramTransform1.q;
    float f4 = localRot1.c;
    float f7 = localVec22.x;
    float f8 = localRot1.s;
    float f9 = localVec22.y;
    float f10 = paramTransform2.p.x;
    float f1 = localRot1.s;
    float f2 = localVec22.x;
    float f3 = localRot1.c;
    float f5 = localVec22.y;
    float f6 = paramTransform2.p.y;
    f4 = f4 * f7 - f8 * f9 + f10 - (localRot2.c * localVec21.x - localRot2.s * localVec21.y + paramTransform1.p.x);
    f5 = f1 * f2 + f3 * f5 + f6 - (localRot2.s * localVec21.x + localRot2.c * localVec21.y + paramTransform1.p.y);
    f6 = localRot2.c;
    f7 = localRot2.s;
    f8 = -localRot2.s;
    f9 = localRot2.c;
    int i = 0;
    f1 = -3.402824E+038F;
    int j = 0;
    while (i < i1)
    {
      localVec21 = arrayOfVec2[i];
      f3 = localVec21.x * (f6 * f4 + f7 * f5) + localVec21.y * (f8 * f4 + f9 * f5);
      f2 = f1;
      if (f3 > f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
      f1 = f2;
    }
    f3 = edgeSeparation(paramPolygonShape1, paramTransform1, j, paramPolygonShape2, paramTransform2);
    i = j - 1;
    if (i < 0) {
      i = i1 - 1;
    }
    int m = i;
    f1 = edgeSeparation(paramPolygonShape1, paramTransform1, m, paramPolygonShape2, paramTransform2);
    i = j + 1;
    if (i >= i1) {
      i = 0;
    }
    f2 = edgeSeparation(paramPolygonShape1, paramTransform1, i, paramPolygonShape2, paramTransform2);
    int k;
    if ((f1 > f3) && (f1 > f2))
    {
      k = -1;
      j = m;
    }
    else
    {
      if (f2 <= f3) {
        break label558;
      }
      f1 = f2;
      k = 1;
    }
    for (j = i;; j = i)
    {
      if (k == -1)
      {
        i = j - 1;
        if (i < 0) {
          i = i1 - 1;
        }
      }
      else
      {
        i = j + 1;
        if (i >= i1) {
          i = 0;
        }
      }
      f2 = edgeSeparation(paramPolygonShape1, paramTransform1, i, paramPolygonShape2, paramTransform2);
      if (f2 <= f1) {
        break;
      }
      f1 = f2;
    }
    paramEdgeResults.edgeIndex = j;
    paramEdgeResults.separation = f1;
    return;
    label558:
    paramEdgeResults.edgeIndex = j;
    paramEdgeResults.separation = f3;
  }
  
  public final boolean testOverlap(Shape paramShape1, int paramInt1, Shape paramShape2, int paramInt2, Transform paramTransform1, Transform paramTransform2)
  {
    this.input.proxyA.set(paramShape1, paramInt1);
    this.input.proxyB.set(paramShape2, paramInt2);
    this.input.transformA.set(paramTransform1);
    this.input.transformB.set(paramTransform2);
    this.input.useRadii = true;
    this.cache.count = 0;
    this.pool.getDistance().distance(this.output, this.cache, this.input);
    return this.output.distance < 1.192093E-006F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Collision
 * JD-Core Version:    0.7.0.1
 */