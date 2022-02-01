package org.jbox2d.profile;

import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.collision.broadphase.DynamicTree;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.JointDef;
import org.jbox2d.dynamics.joints.PrismaticJoint;
import org.jbox2d.dynamics.joints.PrismaticJointDef;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;
import org.jbox2d.pooling.normal.DefaultWorldPool;

public class PistonBenchmark
  extends SettingsPerformanceTest
{
  public static int frames = 800;
  public static int iters = 5;
  public static int posIters = 3;
  public static float timeStep = 0.01666667F;
  public static int velIters = 8;
  public RevoluteJoint m_joint1;
  public PrismaticJoint m_joint2;
  public World world;
  
  public PistonBenchmark()
  {
    super(iters);
  }
  
  public static void main(String[] paramArrayOfString)
  {
    new PistonBenchmark().go();
  }
  
  public int getFrames(int paramInt)
  {
    return frames;
  }
  
  public void runBenchmarkWorld()
  {
    Object localObject1 = new DynamicTree();
    this.world = new World(new Vec2(0.0F, -10.0F), new DefaultWorldPool(100, 10), (BroadPhaseStrategy)localObject1);
    localObject1 = new BodyDef();
    localObject1 = this.world.createBody((BodyDef)localObject1);
    Object localObject2 = new PolygonShape();
    ((PolygonShape)localObject2).setAsBox(5.0F, 100.0F);
    Object localObject3 = new BodyDef();
    ((BodyDef)localObject3).type = BodyType.STATIC;
    Object localObject4 = new FixtureDef();
    ((FixtureDef)localObject4).shape = ((Shape)localObject2);
    ((FixtureDef)localObject4).density = 0.0F;
    ((FixtureDef)localObject4).friction = 0.0F;
    ((FixtureDef)localObject4).restitution = 0.8F;
    ((FixtureDef)localObject4).filter.categoryBits = 4;
    ((FixtureDef)localObject4).filter.maskBits = 2;
    ((BodyDef)localObject3).position.set(-10.01F, 50.0F);
    this.world.createBody((BodyDef)localObject3).createFixture((FixtureDef)localObject4);
    ((BodyDef)localObject3).position.set(10.01F, 50.0F);
    this.world.createBody((BodyDef)localObject3).createFixture((FixtureDef)localObject4);
    localObject2 = new FixtureDef();
    localObject3 = new BodyDef();
    ((BodyDef)localObject3).type = BodyType.DYNAMIC;
    ((BodyDef)localObject3).position = new Vec2(0.0F, 25.0F);
    localObject3 = this.world.createBody((BodyDef)localObject3);
    int k = 0;
    int i = 0;
    while (i < 5)
    {
      localObject4 = new CircleShape();
      ((CircleShape)localObject4).m_radius = 0.5F;
      ((FixtureDef)localObject2).shape = ((Shape)localObject4);
      ((FixtureDef)localObject2).density = 25.0F;
      ((FixtureDef)localObject2).friction = 0.1F;
      ((FixtureDef)localObject2).restitution = 0.9F;
      double d = i / 5;
      Double.isNaN(d);
      d *= 6.283185307179586D;
      f1 = (float)Math.cos(d);
      float f2 = (float)Math.sin(d);
      ((CircleShape)localObject4).m_p.set(f1 * 4.0F, 4.0F * f2);
      ((Body)localObject3).createFixture((FixtureDef)localObject2);
      i += 1;
    }
    localObject2 = new RevoluteJointDef();
    ((RevoluteJointDef)localObject2).initialize((Body)localObject3, (Body)localObject1, ((Body)localObject3).getPosition());
    ((RevoluteJointDef)localObject2).motorSpeed = 3.141593F;
    ((RevoluteJointDef)localObject2).maxMotorTorque = 1000000.0F;
    ((RevoluteJointDef)localObject2).enableMotor = true;
    this.world.createJoint((JointDef)localObject2);
    localObject2 = new PolygonShape();
    ((PolygonShape)localObject2).setAsBox(0.5F, 2.0F);
    localObject3 = new BodyDef();
    ((BodyDef)localObject3).type = BodyType.DYNAMIC;
    ((BodyDef)localObject3).position.set(0.0F, 7.0F);
    localObject3 = this.world.createBody((BodyDef)localObject3);
    ((Body)localObject3).createFixture((Shape)localObject2, 2.0F);
    localObject2 = new RevoluteJointDef();
    ((RevoluteJointDef)localObject2).initialize((Body)localObject1, (Body)localObject3, new Vec2(0.0F, 5.0F));
    ((RevoluteJointDef)localObject2).motorSpeed = 3.141593F;
    ((RevoluteJointDef)localObject2).maxMotorTorque = 20000.0F;
    ((RevoluteJointDef)localObject2).enableMotor = true;
    this.m_joint1 = ((RevoluteJoint)this.world.createJoint((JointDef)localObject2));
    localObject4 = new PolygonShape();
    ((PolygonShape)localObject4).setAsBox(0.5F, 4.0F);
    localObject2 = new BodyDef();
    ((BodyDef)localObject2).type = BodyType.DYNAMIC;
    ((BodyDef)localObject2).position.set(0.0F, 13.0F);
    localObject2 = this.world.createBody((BodyDef)localObject2);
    ((Body)localObject2).createFixture((Shape)localObject4, 2.0F);
    localObject4 = new RevoluteJointDef();
    ((RevoluteJointDef)localObject4).initialize((Body)localObject3, (Body)localObject2, new Vec2(0.0F, 9.0F));
    ((RevoluteJointDef)localObject4).enableMotor = false;
    this.world.createJoint((JointDef)localObject4);
    localObject4 = new PolygonShape();
    ((PolygonShape)localObject4).setAsBox(7.0F, 2.0F);
    localObject3 = new BodyDef();
    ((BodyDef)localObject3).type = BodyType.DYNAMIC;
    ((BodyDef)localObject3).position.set(0.0F, 17.0F);
    localObject3 = this.world.createBody((BodyDef)localObject3);
    FixtureDef localFixtureDef = new FixtureDef();
    localFixtureDef.shape = ((Shape)localObject4);
    localFixtureDef.density = 2.0F;
    localFixtureDef.filter.categoryBits = 1;
    localFixtureDef.filter.maskBits = 2;
    ((Body)localObject3).createFixture(localFixtureDef);
    localObject4 = new RevoluteJointDef();
    ((RevoluteJointDef)localObject4).initialize((Body)localObject2, (Body)localObject3, new Vec2(0.0F, 17.0F));
    this.world.createJoint((JointDef)localObject4);
    localObject2 = new PrismaticJointDef();
    ((PrismaticJointDef)localObject2).initialize((Body)localObject1, (Body)localObject3, new Vec2(0.0F, 17.0F), new Vec2(0.0F, 1.0F));
    ((PrismaticJointDef)localObject2).maxMotorForce = 1000.0F;
    ((PrismaticJointDef)localObject2).enableMotor = true;
    this.m_joint2 = ((PrismaticJoint)this.world.createJoint((JointDef)localObject2));
    localObject3 = new PolygonShape();
    localObject1 = new BodyDef();
    ((BodyDef)localObject1).type = BodyType.DYNAMIC;
    localObject2 = new FixtureDef();
    i = 0;
    while (i < 100)
    {
      ((PolygonShape)localObject3).setAsBox(0.4F, 0.3F);
      ((BodyDef)localObject1).position.set(-1.0F, i + 23.0F);
      ((BodyDef)localObject1).bullet = false;
      localObject4 = this.world.createBody((BodyDef)localObject1);
      ((FixtureDef)localObject2).shape = ((Shape)localObject3);
      ((FixtureDef)localObject2).density = 0.1F;
      ((FixtureDef)localObject2).filter.categoryBits = 2;
      ((FixtureDef)localObject2).filter.maskBits = 7;
      ((Body)localObject4).createFixture((FixtureDef)localObject2);
      i += 1;
    }
    localObject3 = new CircleShape();
    ((CircleShape)localObject3).m_radius = 0.36F;
    i = 0;
    while (i < 100)
    {
      ((BodyDef)localObject1).position.set(1.0F, i + 23.0F);
      ((BodyDef)localObject1).bullet = false;
      ((FixtureDef)localObject2).shape = ((Shape)localObject3);
      ((FixtureDef)localObject2).density = 2.0F;
      ((FixtureDef)localObject2).filter.categoryBits = 2;
      ((FixtureDef)localObject2).filter.maskBits = 7;
      this.world.createBody((BodyDef)localObject1).createFixture((FixtureDef)localObject2);
      i += 1;
    }
    localObject3 = new Vec2[6];
    i = 0;
    float f1 = 0.0F;
    while (i < 6)
    {
      localObject3[i] = new Vec2(MathUtils.cos(f1) * 0.3F, MathUtils.sin(f1) * 0.3F);
      f1 += 1.047198F;
      i += 1;
    }
    localObject4 = new PolygonShape();
    ((PolygonShape)localObject4).set((Vec2[])localObject3, 6);
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 100) {
        break;
      }
      ((BodyDef)localObject1).position.set(0.0F, i + 23.0F);
      ((BodyDef)localObject1).type = BodyType.DYNAMIC;
      ((BodyDef)localObject1).fixedRotation = true;
      ((BodyDef)localObject1).bullet = false;
      ((FixtureDef)localObject2).shape = ((Shape)localObject4);
      ((FixtureDef)localObject2).density = 1.0F;
      ((FixtureDef)localObject2).filter.categoryBits = 2;
      ((FixtureDef)localObject2).filter.maskBits = 7;
      this.world.createBody((BodyDef)localObject1).createFixture((FixtureDef)localObject2);
      i += 1;
    }
    while (j < frames)
    {
      this.world.step(timeStep, posIters, velIters);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.profile.PistonBenchmark
 * JD-Core Version:    0.7.0.1
 */